package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            BookService xmlConfiguredService = context.getBean("bookServiceXml", BookService.class);
            BookService annotationConfiguredService = context.getBean("bookService", BookService.class);

            System.out.println("XML bean injection summary: " + xmlConfiguredService.injectionSummary());
            xmlConfiguredService.addBook("Spring in Action");
            xmlConfiguredService.printBook(1001);

            System.out.println("Annotation bean injection summary: " + annotationConfiguredService.injectionSummary());
            annotationConfiguredService.addBook("Clean Code");
            annotationConfiguredService.printBook(1002);
        }
    }
}
