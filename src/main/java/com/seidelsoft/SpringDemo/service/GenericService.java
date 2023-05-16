package com.seidelsoft.SpringDemo.service;

import com.seidelsoft.SpringDemo.model.GenericEntity;
import com.seidelsoft.SpringDemo.repository.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericService<T extends GenericEntity<T>> {

    private final GenericRepository<T> repository;

    public GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }

    public Page<T> getPage(Pageable pageable){
        return repository.findAll(pageable);
    }

    public T get(Long id) throws Exception {
        return repository.findById(id).orElseThrow(
                () -> new Exception(String.valueOf(id))
        );
    }

    @Transactional
    public T update(T updated) throws Exception {
        T dbDomain = get(updated.getId());
        dbDomain.update(updated);

        return repository.save(dbDomain);
    }

    @Transactional
    public T create(T newDomain){
        T dbDomain = newDomain.createNewInstance();
        return repository.save(dbDomain);
    }

    @Transactional
    public void delete(Long id) throws Exception {
        //check if object with this id exists
        get(id);
        repository.deleteById(id);
    }
}