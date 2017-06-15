package com.example.demo.service;

import com.example.demo.domain.Book;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jimmy on 2017/6/15.
 */
@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return  Lists.newArrayList(this.bookRepository.findAll());
    }

    public Book createOneBook(Book book){
        return this.bookRepository.save(book);
    }
}
