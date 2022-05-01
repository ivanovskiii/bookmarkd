package com.finki.bookmarkd.service;

import com.finki.bookmarkd.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserBookService {
    UserBook findById(Long id);
    UserBook addBookOnShelf(User user, Book book, readingStatus readingStatus);
    UserBook deleteBookOnShelf(Long id);
    UserBook updateBookShelf(Long userBookId,readingStatus readingStatus, Integer rating, LocalDate startedDate, LocalDate completedDate);
    List<UserBook> listByStatus(readingStatus readingStatus);
}
