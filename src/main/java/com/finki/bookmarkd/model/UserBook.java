package com.finki.bookmarkd.model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "userbook")
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userbook_id")
    private Long id;

    @Column(name = "starteddate")
    private LocalDate startedDate;

    @Column(name = "completeddate")
    private LocalDate completedDate;

    @Column(name = "rating")
    private Integer rating;

    @Enumerated(EnumType.STRING)
    private readingStatus readingStatus;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    public UserBook(User user, Book book, readingStatus readingStatus) {
        this.user=user;
        this.book=book;
        this.readingStatus=readingStatus;
    }

    public UserBook() {

    }

    public User getUser() {
        return user;
    }

    public UserBook(User user, Book book, LocalDate startedDate, LocalDate completedDate, Integer rating,
                    readingStatus readingStatus) {
        this.book = book;
        this.user = user;
        this.startedDate = startedDate;
        this.completedDate = completedDate;
        this.rating = rating;
        this.readingStatus = readingStatus;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(LocalDate startedDate) {
        this.startedDate = startedDate;
    }

    public LocalDate getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDate completedDate) {
        this.completedDate = completedDate;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public com.finki.bookmarkd.model.readingStatus getReadingStatus() {
        return readingStatus;
    }

    public void setReadingStatus(com.finki.bookmarkd.model.readingStatus readingStatus) {
        this.readingStatus = readingStatus;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
