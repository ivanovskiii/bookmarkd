package com.finki.bookmarkd.service.imp;

import com.finki.bookmarkd.model.Genre;
import com.finki.bookmarkd.model.exceptions.InvalidGenreIdException;
import com.finki.bookmarkd.repository.GenreRepository;
import com.finki.bookmarkd.service.GenreService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImp implements GenreService {

    @Autowired
    private final GenreRepository genreRepository;

    public GenreServiceImp(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre findById(Long id) {
        return this.genreRepository.findById(id).orElseThrow(InvalidGenreIdException::new);
    }

    @Override
    public List<Genre> listAll() {
        return this.genreRepository.findAll();
    }

    @Override
    public List<Genre> listGenreByName(String keyword) {
        if(keyword!=null){
            return genreRepository.search(keyword);
        }
        return genreRepository.findAll();
    }


}
