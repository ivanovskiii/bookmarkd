package com.finki.bookmarkd.repository;

import com.finki.bookmarkd.model.Book;
import com.finki.bookmarkd.model.Genre;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    Optional<Genre> findById(Long id);
    Genre findAllById(Long id);
    @Query("SELECT g FROM Genre as g WHERE CONCAT(g.name,'') LIKE %?1%")
    public List<Genre> search(String keyword);
}
