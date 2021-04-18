package com.swalikh.auto.autobuilder.base;

import org.springframework.data.domain.Example;
import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable, R extends BaseRepository<T, ID>> {

    R getRepository();  //获取Repository

    T addAndSave(T entity); //添加

    void deleteById(ID id); //通过ID删除

    T getByID(ID id);  //通过id找到该实体

    List<T> getAll();  //查所有

    List<T> getAllByExample(Example<T> example); //按条件查所有

    Boolean isExist(ID id);

}