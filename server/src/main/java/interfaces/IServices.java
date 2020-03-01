package interfaces;

import model.Firm;

import java.util.List;

public interface IServices<T> {
    List<T> get();
    void set(List<T> firms);
    boolean create(T object);
    boolean delete(T object);
    boolean update(T source, T destination);
    T find(int id);
}
