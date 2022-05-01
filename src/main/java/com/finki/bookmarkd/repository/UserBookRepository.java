package com.finki.bookmarkd.repository;

import com.finki.bookmarkd.model.User;
import com.finki.bookmarkd.model.UserBook;
import com.finki.bookmarkd.model.readingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, Long> {
    List<UserBook> findAllByReadingStatus(readingStatus readingStatus);

    UserBook findByUserAndBook(User userId, Long bookId);

    //List<UserBook> findAll(Long id);
}
