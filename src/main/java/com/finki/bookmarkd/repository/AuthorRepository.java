package com.finki.bookmarkd.repository;

import com.finki.bookmarkd.model.Author;
import com.finki.bookmarkd.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author as a WHERE CONCAT(a.name, '') LIKE %?1%")
    public List<Author> search(String keyword);
//    List<Book> findAllBooksByAuthor(Long id);
    Optional<Author> findAllById(Optional<Author> authorsId);
}
