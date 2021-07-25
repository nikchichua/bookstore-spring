package com.learn.springreact.repositories;

import com.learn.springreact.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    @Query("From Book book WHERE " +
            "book.title LIKE %:search% OR " +
            "book.author LIKE %:search% OR " +
            "book.isbnNumber LIKE %:search% OR " +
            "book.language LIKE %:search%" /*+ " OR " + "book.imageUrl LIKE %:search%"*/
    )
    Page<Book> searchForBooks(Pageable pageable, @Param("search") String search);
}
