package com.seidelsoft.SpringDemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Book implements Serializable, GenericEntity<Book> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String author;

    @Lob
    private String description;

    private Date releaseDate;

    @Override
    public Long getId(){
        return this.id;
    }

    @Override
    public void update(Book source) {
        this.title = source.getTitle();
        this.author =source.getAuthor();
        this.description = source.getDescription();
        this.releaseDate = source.getReleaseDate();
    }

    @Override
    public Book createNewInstance() {
        Book newInstance = new Book();
        newInstance.update(this);

        return newInstance;
    }
}