package com.finki.bookmarkd.web.controller;

import com.finki.bookmarkd.model.Author;
import com.finki.bookmarkd.model.Book;
import com.finki.bookmarkd.service.AuthorService;
import com.finki.bookmarkd.service.BookService;
import com.finki.bookmarkd.service.UserBookService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AuthorController {

    @Autowired
    private final BookService bookService;
    private final UserBookService userBookService;
    private final AuthorService authorService;


    public AuthorController(BookService bookService, UserBookService userBookService, AuthorService authorService) {
        this.bookService = bookService;
        this.userBookService = userBookService;
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String getAuthorsListPage(Model model){
        List<Author> listAuthors = authorService.listAllAuthors();
        model.addAttribute("listAuthors", listAuthors);

        return "authors";
    }

    @GetMapping("/author/{authorId}")
    public String getAuthorPage(Model model, @PathVariable Long authorId){
        Author author = authorService.findById(authorId);
        model.addAttribute("author", author);

        return "authorPage";
    }


}
