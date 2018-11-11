package ald.rc.dal;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T, D> {
    int insert(T t);
    int update(T t);
    T findByPrimary(D d);
    int delete(D d);
    List<T> listSelective(Map<String,Object> param);
}
