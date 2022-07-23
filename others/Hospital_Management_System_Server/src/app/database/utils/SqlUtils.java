package app.database.utils;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class SqlUtils {
    public static String createSelectQuery(String tableName, Set<String> selectors, Set<String> columns) {
        StringBuilder query = new StringBuilder("");
        if(columns.size() > 0 && selectors.size() > 0) {
            query.append("SELECT ");

            columns.forEach(column->{
                query.append(column).append(", ");
            });

            int index = query.lastIndexOf(",");
            query.deleteCharAt(index);

            query.append(" FROM ")
                    .append(tableName)
                    .append(" WHERE ");

            selectors.forEach(selector->{
                query.append(selector)
                        .append(" = ? and ");
            });

            index = query.lastIndexOf("and");
            query.replace(index,index+3," ;");

            return query.toString();
        }
        else if(columns.size() > 0) {
            query.append("SELECT ");

            columns.forEach(column->{
                query.append(column).append(", ");
            });

            int index = query.lastIndexOf(",");
            query.deleteCharAt(index);

            query.append(" FROM ")
                    .append(tableName)
                    .append(" ;");

            return query.toString();

        }
        else if(selectors.size() > 0) {
            query.append("SELECT * FROM ")
                    .append(tableName)
                    .append(" WHERE ");

            selectors.forEach(selector->{
                query.append(selector)
                        .append(" = ? and ");
            });

            int index = query.lastIndexOf("and");
            query.replace(index,index+3," ;");

            return query.toString();

        }
        else  {
            query.append("SELECT * FROM ")
                    .append(tableName)
                    .append(" ;");


            return query.toString();
        }
    }


    public static String createSelectAllByColumnsQuery(String tableName, Set<String> selectors) {

        Set<String> columns = new LinkedHashSet<>();
        return createSelectQuery(
                tableName, selectors, columns
        );
    }

    public static String createSelectAllByColumnsQuery(String tableName, String... selectors) {
        Set<String> sels = new LinkedHashSet<>(Arrays.asList(selectors));
        return createSelectAllByColumnsQuery(tableName,sels);
    }

    public static String createSelectColumnsQuery(String tableName, Set<String> columns) {
        return createSelectQuery(
                tableName, new LinkedHashSet<>(), columns
        );
    }

    public static String createSelectColumnsQuery(String tableName, String... columns) {
        Set<String> cols = new LinkedHashSet<>(Arrays.asList(columns));
        return createSelectColumnsQuery(tableName, cols);
    }

    public static String CreateSelectAllQuery(String tableName) {
        return createSelectQuery(
                tableName, new LinkedHashSet<>(), new LinkedHashSet<>()
        );
    }


    public static String createInsertQuery(String tableName, Set<String> columns) {

        if(columns.size() == 0) {
            throw new RuntimeException("The number of columns should be greater than zero");

        }

        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " (");
        StringBuilder commas = new StringBuilder("");

        columns.forEach(column -> {
            query.append(column).append(" ,");
            commas.append("?,");
        });

        int index = query.lastIndexOf(",");
        query.deleteCharAt(index);

        index = commas.lastIndexOf(",");
        commas.deleteCharAt(index);


        query
                .append(") VALUES (")
                .append(commas)
                .append(");");
        return query.toString();

    }
    public static String createInsertQuery(String tableName, String... columns){
        Set<String> cols = new LinkedHashSet<>(Arrays.asList(columns));
        return createInsertQuery(tableName,cols);
    }

    public static String createUpdateQuery(String tableName, Set<String> columns, Set<String> selectors) {
        if (columns.size() == 0) {
            throw new RuntimeException("Number of columns should be greater than zero");
        }
        if (selectors.size() == 0) {
            throw new RuntimeException("Number of selectors should be greater than zero");
        }

        StringBuilder query = new StringBuilder("");
        query.append("UPDATE ").append(tableName).append(" set ");

        columns.forEach(column->{
            query.append(column).append(" = ?, ");
        });

        int index =  query.lastIndexOf(",");
        query.deleteCharAt(index);

        query.append(" WHERE ");

        selectors.forEach(selector->{
            query.append(selector).append(" = ? and ");
        });

        index = query.lastIndexOf("and");
        query.delete(index,index + 3);

        query.append(" ;");

        return query.toString();
    }

    public static String createDeleteQuery(String tableName, Set<String> selectors) {
        StringBuilder query = new StringBuilder("");

        if(selectors.size() == 0) {
            throw new RuntimeException("The number of columns should be greater than 0");
        }

           query.append("DELETE FROM ")
                .append(tableName)
                .append(" WHERE ");

        selectors.forEach(column->{
            query.append(column)
                    .append(" =? and ");
        });

        int index = query.lastIndexOf("and");
        query.replace(index,index+3," ;");

        return query.toString();
    }

    public static String createDeleteQuery(String tableName, String... selectors) {
        return createDeleteQuery(tableName,new LinkedHashSet<String>(Arrays.asList(selectors)));
    }





}
