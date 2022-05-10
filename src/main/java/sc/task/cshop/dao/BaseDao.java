package sc.task.cshop.dao;

import java.util.List;


public interface BaseDao <T>{
    List<T> findAll();
    T findById(Long id);
    boolean create(T entity);
    T update (T entity);
    boolean deleteById (Long id);

}
