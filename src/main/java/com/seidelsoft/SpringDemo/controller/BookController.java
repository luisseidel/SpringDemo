package com.seidelsoft.SpringDemo.controller;

import com.seidelsoft.SpringDemo.model.Book;
import com.seidelsoft.SpringDemo.repository.BookRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController extends GenericController<Book> {

    public BookController(BookRepository bookRepository) {
        super(bookRepository);
    }
}