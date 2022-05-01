package com.finki.bookmarkd.service.imp;

import com.finki.bookmarkd.model.Author;
import com.finki.bookmarkd.model.Book;
import com.finki.bookmarkd.model.exceptions.InvalidArgumentException;
import com.finki.bookmarkd.repository.AuthorRepository;
import com.finki.bookmarkd.repository.BookRepository;
import com.finki.bookmarkd.service.AuthorService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorServiceImp(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Author> listAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findById(id).orElseThrow(InvalidArgumentException::new);
    }

//    @Override
//    public List<Book> listBooksByAuthor(Long id) {
//        return this.authorRepository.findAllBooksByAuthor(id);
//    }
}
