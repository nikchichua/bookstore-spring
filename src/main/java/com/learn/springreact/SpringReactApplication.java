package com.learn.springreact;

import com.learn.springreact.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringReactApplication implements CommandLineRunner, WebMvcConfigurer {

    @Autowired
    private BookService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringReactApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        for(int i = 1; i < 65; i++) {
//            Book book = new Book();
//            book.setTitle(i + "");
//            book.setAuthor("Author " + i);
//            book.setImageUrl("Book URL " + i);
//            book.setIsbnNumber("259358839" + i);
//            book.setPrice(i);
//            book.setLanguage("Language " + i);
//            service.addBook(book);
//        }
    }

}
