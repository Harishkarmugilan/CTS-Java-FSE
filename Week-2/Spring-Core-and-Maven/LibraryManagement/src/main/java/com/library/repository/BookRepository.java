package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void saveBook(String title) {
        System.out.println("BookRepository: saving book -> " + title);
    }

    public String findBookById(int id) {
        return "Book-" + id;
    }
}
