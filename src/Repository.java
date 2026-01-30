package repository.interfaces;
import java.util.List;

public interface Repository<T> {
    void create(T entity);
    T read(int id);
    List<T> readAll();
    void update(T entity);
    void delete(int id);
}