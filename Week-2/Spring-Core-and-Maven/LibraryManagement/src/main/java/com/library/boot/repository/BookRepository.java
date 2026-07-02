package com.library.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.boot.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
