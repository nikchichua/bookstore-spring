package com.learn.springreact.controllers;

import com.learn.springreact.entities.Book;
import com.learn.springreact.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/books")
@CrossOrigin("*")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public Page<Book> getAllBooks(int page, int size, String sortBy, String sortDirection,
                                  @RequestParam(defaultValue = "") String search) throws UnsupportedEncodingException {
        return service.getAllBooks(
                PageRequest.of(page, size,
                    sortDirection.equalsIgnoreCase("ascending") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                ),
                search
        );
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return service.getBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return service.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        service.deleteBook(id);
    }

}
