package com.finki.bookmarkd.service.imp;

import com.finki.bookmarkd.model.*;
import com.finki.bookmarkd.repository.AuthorRepository;
import com.finki.bookmarkd.repository.UserBookRepository;
import com.finki.bookmarkd.service.UserBookService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserBookServiceImp implements UserBookService {

    private final UserBookRepository userBookRepository;
    private final AuthorRepository authorRepository;

    public UserBookServiceImp(UserBookRepository userBookRepository, AuthorRepository authorRepository) {
        this.userBookRepository = userBookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public UserBook findById(Long id) {
        return this.userBookRepository.findById(id).orElseThrow();
    }

    @Override
    public UserBook addBookOnShelf(User user, Book book, readingStatus readingStatus) {
        UserBook userBook = new UserBook(user, book, readingStatus);
        return this.userBookRepository.save(userBook);
    }

    @Override
    public UserBook deleteBookOnShelf(Long id) {
        UserBook userBook=this.findById(id);
        this.userBookRepository.delete(userBook);
        return userBook;
    }

    @Override
    public UserBook updateBookShelf(Long userBookId, readingStatus readingStatus, Integer rating, LocalDate startedDate, LocalDate completedDate) {
        UserBook userBook=this.findById(userBookId);
        userBook.setReadingStatus(readingStatus);
        userBook.setRating(rating);
        userBook.setStartedDate(startedDate);
        userBook.setCompletedDate(completedDate);

        return this.userBookRepository.save(userBook);
    }

    @Override
    public List<UserBook> listByStatus(readingStatus readingStatus) {
        List<UserBook> userBook = this.userBookRepository.findAllByReadingStatus(readingStatus);
        return userBook;
    }

}
