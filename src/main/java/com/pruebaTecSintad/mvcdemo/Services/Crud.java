package com.pruebaTecSintad.mvcdemo.Services;

import java.util.List;

public interface Crud<T,ID>{
    T save(T t);
     T update(T t);
    T findById(ID id);
    List<T> findAll();
    void delete(ID id);
}
