package com.swalikh.auto.autobuilder.base;


import com.swalikh.auto.autobuilder.exception.CodeMsg;
import com.swalikh.auto.autobuilder.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
@SuppressWarnings("all")
public abstract class BaseServiceImpl<T, ID extends Serializable, R extends BaseRepository<T, ID>> implements BaseService<T, ID, R> {

    public abstract T getEntityType();

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected R baseRepository;

    @Override
    public R getRepository() {
        return baseRepository;
    }

    @Override
    public T addAndSave(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
            baseRepository.deleteById(id);
    }

    public T updateByID(T entity) {
        return baseRepository.saveAndFlush(entity);
    }

    @Override
    public T getByID(ID id) {
        Optional<T> result = baseRepository.findById(id);
        String simpleName = getEntityType().getClass().getSimpleName();
        if(!result.isPresent())
            throw new GlobalException(CodeMsg.CAN_NOT_FIND.fillArgs(simpleName+"-"+id));
        return result.get();
    }

    @Override
    public List<T> getAll() {
        return baseRepository.findAll();
    }

    @Override
    public List<T> getAllByExample(Example<T> example) {
        return baseRepository.findAll(example);
    }


    @Override
    public Boolean isExist(ID id) {
        return baseRepository.existsById(id);
    }

}