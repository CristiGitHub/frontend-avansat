package com.fmi.demo.exposition.IQuerry;

import java.util.List;

public interface IQuerry <T>{

    T getById(String id);
    List<T> getAll();
}
