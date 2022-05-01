package com.finki.bookmarkd.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long id;

    @Column(name = "genre_name")
    private String name;

    @ManyToMany
    @JoinTable(
            name="belongs",
            joinColumns = @JoinColumn(name="genre_id"),
            inverseJoinColumns = @JoinColumn(name="book_id")
    )
    private List<Book> book;

    public Genre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
