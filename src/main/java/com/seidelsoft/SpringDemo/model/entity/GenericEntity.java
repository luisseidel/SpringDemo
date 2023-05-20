package com.seidelsoft.SpringDemo.model.entity;

public interface GenericEntity<T> {
    // update current instance with provided data
    void update(T source);

    // based on current data create new instance with new id
    T createNewInstance();
}
