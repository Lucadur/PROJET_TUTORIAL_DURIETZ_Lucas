package com.junia.demo.repository.entity;

import jakarta.persistence.*;
import java.util.List;

import java.time.LocalDate;

@Entity
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate createdDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    public Tutorial(String name, LocalDate createdDate, Long id, String description,Author author ) {
        this.name = name;
        this.createdDate = createdDate;
        this.id = id;
        this.author = author;
        this.description = description;
    }

    public Tutorial() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}


