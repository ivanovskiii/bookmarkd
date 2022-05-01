package com.finki.bookmarkd.service.imp;

import com.finki.bookmarkd.model.Book;
import com.finki.bookmarkd.model.exceptions.InvalidBookIdException;
import com.finki.bookmarkd.repository.BookRepository;
import com.finki.bookmarkd.repository.GenreRepository;
import com.finki.bookmarkd.service.BookService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
    }

//
//    @Override
//    public Optional<Book> findByName(String name) {
//        return this.bookRepository.findByName(name);
//    }

    @Override
    public List<Book> listBookByName(String keyword) {
        if(keyword!=null){
            return bookRepository.search(keyword);
        }
        return bookRepository.findAll();
    }
//
//    @Override
//    public Optional<Book> listBooksByAuthor(Long id) {
//        return this.bookRepository.findAllByAuthor(id);
//    }

    @Override
    public Optional<Book> listBooksByGenre(Long id) {
        return this.bookRepository.findAllByGenre(id);
    }
}
