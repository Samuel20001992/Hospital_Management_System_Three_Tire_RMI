package app.database;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T extends BaseModel> {
    List<T> getAllEntities();

    boolean addEntity(T entity);

    Optional<T> findById(int id);

    public List<T> findByColumn(String columnName, Object value);

    default int countByColumn(String columnName,Object value) {
        return findByColumn(columnName, value).size();
    }

    Optional<T> updateById(int id, T entity);

    boolean deleteById(int id);

    default void close() {}
}
