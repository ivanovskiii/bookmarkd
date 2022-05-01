package com.finki.bookmarkd.service;

import com.finki.bookmarkd.model.Author;
import com.finki.bookmarkd.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> listAllBooks();

    Book findById(Long id);

//    List<Book> listBooksByAuthor(Long authorId);

    Optional<Book> listBooksByGenre(Long id);

//    Optional<Book> findByName(String name);

    List<Book> listBookByName(String keyword);//search

}
