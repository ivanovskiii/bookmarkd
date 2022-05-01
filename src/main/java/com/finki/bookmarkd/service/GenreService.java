package com.finki.bookmarkd.service;

import com.finki.bookmarkd.model.Author;
import com.finki.bookmarkd.model.Genre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreService{
    Genre findById(Long id);

    List<Genre> listAll();

    List<Genre> listGenreByName(String keyword);

}
