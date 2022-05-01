package com.finki.bookmarkd.repository;

import com.finki.bookmarkd.model.Author;
import com.finki.bookmarkd.model.Book;
import com.finki.bookmarkd.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String text);
//    Optional<Book> findAllByAuthor(Long id);
    Optional<Book> findAllByGenre(Long id);
    @Query("SELECT b FROM Book as b WHERE CONCAT(b.name,'') LIKE %?1%")
    public List<Book> search(String keyword);

}
