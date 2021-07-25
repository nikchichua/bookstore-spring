package com.learn.springreact.services;

import com.learn.springreact.entities.Book;
import com.learn.springreact.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public Page<Book> getAllBooks(Pageable pageable, String search) {
        return repository.searchForBooks(pageable, search);
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public void deleteBook(long id) {
        repository.deleteById(id);
    }

    public Book getBookById(long id) {
        return repository.findById(id).orElse(null);
    }

    public Book updateBook(Book book) {
        return repository.save(book);
    }
}
