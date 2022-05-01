package com.finki.bookmarkd.service;

import com.finki.bookmarkd.model.Author;

import com.finki.bookmarkd.model.Book;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAllAuthors();
    Author findById(Long id);
//    List<Book> listBooksByAuthor(Long id);

}
