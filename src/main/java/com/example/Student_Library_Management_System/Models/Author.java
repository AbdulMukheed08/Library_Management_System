package com.example.Student_Library_Management_System.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;

    private int age;

    private String country;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> booksWritten = new ArrayList<>();

    public Author() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(List<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }
}
