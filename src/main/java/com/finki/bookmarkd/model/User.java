package com.finki.bookmarkd.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @OneToMany
    @JoinColumn(name="usersbook_id")
    private List<UserBook> userBook;

    @OneToMany
    @JoinColumn(name="book_id")
    private List<Book> book;

    public User() {
    }

    public User(String username, String password, String name, String surname, List<Book> book, List<UserBook> userBook) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.book = book;
        this.userBook = new ArrayList<>();
    }

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<UserBook> getUserBook() {
        return userBook;
    }

    public void setUserBook(List<UserBook> userBook) {
        this.userBook = userBook;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
