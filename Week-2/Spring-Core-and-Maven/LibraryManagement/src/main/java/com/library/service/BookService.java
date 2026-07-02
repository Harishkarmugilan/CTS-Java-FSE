package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.BookRepository;

@Service
public class BookService {

    private BookRepository constructorInjectedRepository;
    private BookRepository bookRepository;

    public BookService() {
    }

    public BookService(BookRepository constructorInjectedRepository) {
        this.constructorInjectedRepository = constructorInjectedRepository;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        BookRepository repo = resolveRepository();
        repo.saveBook(title);
        System.out.println("BookService: added book -> " + title);
    }

    public void printBook(int id) {
        BookRepository repo = resolveRepository();
        String book = repo.findBookById(id);
        System.out.println("BookService: found -> " + book);
    }

    public String injectionSummary() {
        return "constructorInjected=" + (constructorInjectedRepository != null)
                + ", setterInjected=" + (bookRepository != null);
    }

    private BookRepository resolveRepository() {
        if (bookRepository != null) {
            return bookRepository;
        }
        if (constructorInjectedRepository != null) {
            return constructorInjectedRepository;
        }
        throw new IllegalStateException("BookRepository dependency not configured");
    }
}
