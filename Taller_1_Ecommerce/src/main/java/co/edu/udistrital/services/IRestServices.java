package co.edu.udistrital.services;

import java.util.List;

public interface IRestServices <T>{
    List<T> getAll();
    T AddNew(T t);
    T getById(int id);
    T Update(int id, T t);
    void Delete(int id);
}
