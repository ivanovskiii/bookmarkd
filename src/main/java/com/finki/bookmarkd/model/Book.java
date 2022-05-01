package com.finki.bookmarkd.model;

import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "book_date")
    private String datePublished;

    @Column(name = "book_desc")
    private String description;

    @Column(name = "book_cover")
    private String bookCover;

    @ManyToMany
    @JoinTable(
            name="belongs",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="genre_id")
    )
    private List<Genre> genre;

    @ManyToMany
    @JoinTable(
            name="writtenby",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id")
    )
    private List<Author> author;

    @ManyToMany
    @JoinTable(
            name="readby",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private List<User> user;

    public Book(String name, String datePublished, String description, List<Author> author, List<User> user,
                String bookCover, List<Genre> genre) {
        this.name = name;
        this.datePublished = datePublished;
        this.description = description;
        this.author = author;
        this.user = user;
        this.bookCover = bookCover;
        this.genre = genre;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

}
