package app.database;

import app.database.utils.SqlUtils;

import java.sql.*;
import java.util.*;

import static app.database.DbConnection.getConnection;

public abstract class BaseMysql<T extends BaseModel> implements BaseDao<T> {

    private String selectByIdQuery = "";
    private String insertQuery = "";
    private String updateByIdQuery = "";
    private String deleteByIdQuery = "";
    private String selectAllQuery = "";


    private PreparedStatement selectByIdPreparedStatement ;
    private PreparedStatement insertPreparedStatement ;
    private PreparedStatement updateByIdPreparedStatement;
    private PreparedStatement deleteByIdPreparedStatement ;
    private Statement selectAllStatement ;

    

    private String entityName;
    private String tableName;
    private String idColumn;

    Set<String> insertColumns;
    Set<String> updateByIdColumns;

    public BaseMysql(String entityName, String tableName, String idColumn) {
        this.entityName = entityName;
        this.tableName = tableName;
        this.idColumn = idColumn;

        insertColumns = insertColumns();
        updateByIdColumns = insertColumns();

        setQueries();

        Connection connection = getConnection();
        try {
            this.selectAllStatement = connection.createStatement();
            this.selectByIdPreparedStatement = connection.prepareStatement(this.selectByIdQuery);
            this.insertPreparedStatement = connection.prepareStatement(this.insertQuery);
            this.updateByIdPreparedStatement = connection.prepareStatement(this.updateByIdQuery);
            this.deleteByIdPreparedStatement = connection.prepareStatement(this.deleteByIdQuery);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }



    }

    protected void setQueries(){

        this.selectAllQuery = SqlUtils.createSelectAllByColumnsQuery(tableName);
        this.selectByIdQuery = SqlUtils.createSelectAllByColumnsQuery(tableName,idColumn);
        this.deleteByIdQuery = SqlUtils.createDeleteQuery(tableName,idColumn);

        this.insertQuery = SqlUtils.createInsertQuery(tableName,insertColumns());


        this.updateByIdQuery = SqlUtils.createUpdateQuery(
                tableName,
                updateByIdColumns,
                new LinkedHashSet<String>(Arrays.asList(idColumn))
        );
    }




    @Override
    public List<T> getAllEntities() {
        List<T> entities = new ArrayList<>();

        try {
            ResultSet resultSet = selectAllStatement.executeQuery(selectAllQuery);
            while (resultSet.next()) {
                T entity = getEntityFromResultSet(resultSet);
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public boolean addEntity(T entity) {
        try {
            prepareInsertStatement(insertPreparedStatement,entity);
            insertPreparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<T> findById(int id) {
        try {
            prepareSelectByIdStatement(id);
            ResultSet resultSet = selectByIdPreparedStatement.executeQuery();
            if(resultSet.next()) {
                T entity = getEntityFromResultSet(resultSet);
                return Optional.of(entity);
            }
            else {
                System.err.println(entityName + " with id " + id + " not found.");
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<T> findByColumn(String columnName, Object value) {

        List<T> entities = new ArrayList<>();

        String query = SqlUtils.createSelectAllByColumnsQuery(tableName,columnName);

        try{
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setObject(1,value);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                T entity = getEntityFromResultSet(resultSet);
                entities.add(entity);
            }

            preparedStatement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


        return entities;
    }

    //Experimental
    public List<T> findByMultipleColumns(String tableName, Map<String, Object> values) {
        List<T> entities = new ArrayList<>();

        String query = SqlUtils.createSelectAllByColumnsQuery(tableName,values.keySet());

        try{
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            int i = 1;
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                preparedStatement.setObject(i,value);
            }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


        return entities;
    }

    @Override
    public Optional<T> updateById(int id, T entity) {
        if(!findById(id).isPresent()) return Optional.empty();

        try {
            prepareUpdateStatement(updateByIdPreparedStatement,entity,id);
            updateByIdPreparedStatement.executeUpdate();
            T newEntity = (T) entity.clone();
            newEntity.setId(id);
            return Optional.of(newEntity);
        } catch (SQLException | CloneNotSupportedException e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }

    @Override
    public boolean deleteById(int id) {

        if(!findById(id).isPresent()) {
            return false;
        }

        try {
            prepareDeleteByIdStatement(id);
            deleteByIdPreparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void close() {
        try {
            this.selectAllStatement.close();
            this.selectByIdPreparedStatement.close();
            this.insertPreparedStatement.close();
            this.updateByIdPreparedStatement.close();
            this.deleteByIdPreparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract Set<String> insertColumns();
   // protected abstract Set<String> updateByIdColumns();

    protected abstract T getEntityFromResultSet(ResultSet resultSet) throws SQLException;


    protected void prepareSelectByIdStatement(int id) throws SQLException {
        this.selectByIdPreparedStatement.setInt(1,id);
    }
    protected void prepareDeleteByIdStatement(int id) throws SQLException {
        this.deleteByIdPreparedStatement.setInt(1,id);
    }

    protected abstract void prepareInsertStatement(PreparedStatement preparedStatement, T entity) throws SQLException;

    protected void prepareUpdateStatement(PreparedStatement preparedStatement, T entity, int id) throws SQLException {
        int idPos = updateByIdColumns.size() + 1;
        prepareInsertStatement(updateByIdPreparedStatement,entity);
        updateByIdPreparedStatement.setInt(idPos,id);
    }
    protected void prepareUpdateStatement(PreparedStatement preparedStatement, T entity) throws SQLException {
        prepareUpdateStatement(preparedStatement,entity,entity.getId());
    }


    public void printQueries() {
        System.out.println(this.selectAllQuery);
        System.out.println(this.selectByIdQuery);
        System.out.println(this.insertQuery);
        System.out.println(this.updateByIdQuery);
        System.out.println(this.deleteByIdQuery);
    }
}
