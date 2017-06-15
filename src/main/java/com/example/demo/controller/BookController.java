package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Jimmy on 2017/6/15.
 */
@RestController
@RequestMapping("/api/v1")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(path="/books", method = RequestMethod.GET)
    public List<Book> listBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping(path="/books", method = RequestMethod.POST)
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book){
        Book savedBook = bookService.createOneBook(book);
        return new ResponseEntity(savedBook, HttpStatus.OK);
    }

}
