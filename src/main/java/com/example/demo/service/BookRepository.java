package com.example.demo.service;

import com.example.demo.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jimmy on 2017/6/15.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
