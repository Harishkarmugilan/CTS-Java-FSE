package com.example;

public interface OrderRepository {

    void save(String item);

    String findById(int id);

    String nextReference();
}
