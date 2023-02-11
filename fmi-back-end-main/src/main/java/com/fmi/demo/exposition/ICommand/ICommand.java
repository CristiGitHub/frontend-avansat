package com.fmi.demo.exposition.ICommand;


public interface ICommand <T> {
    String save(T body);
    String update(T body, String id);
    void delete(String id);
}
