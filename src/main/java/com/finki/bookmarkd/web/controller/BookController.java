package com.finki.bookmarkd.web.controller;

import com.finki.bookmarkd.model.*;
import com.finki.bookmarkd.service.AuthorService;
import com.finki.bookmarkd.service.BookService;
import com.finki.bookmarkd.service.GenreService;
import com.finki.bookmarkd.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {

    @Autowired
    private final BookService bookService;
    private final UserBookService userBookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    public BookController(BookService bookService, UserBookService userBookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.userBookService = userBookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @GetMapping()
    public String showHome(Model model, @Param("keyword") String keyword){
        List<Book> listBooks=bookService.listBookByName(keyword); // search & list all books
        List<Genre> listGenres=genreService.listAll();
        model.addAttribute("genres", listGenres);
        model.addAttribute("books", listBooks);
        model.addAttribute("keyword", keyword);

        return "home";
    }

    @PostMapping("/add-book/book={bookId}")
    public String addBookOnShelf(HttpServletRequest request, @PathVariable Long bookId){
            User user = (User) request.getSession().getAttribute("user");
            Book book=this.bookService.findById(bookId);
            this.userBookService.addBookOnShelf(user, book, readingStatus.TO_READ);
            return "redirect:/";
    }

    @GetMapping("/genre/book/{genreId}")
    public String showBooksByGenre(Model model, @PathVariable Long genreId){
        Genre genre = genreService.findById(genreId);
        List<Genre> listGenres=genreService.listAll();
        model.addAttribute("genres", listGenres);
        model.addAttribute("genre", genre);

        return "booksGenre";
    }

}
