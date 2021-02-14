package com.enigma.library.entities;


import jdk.jfr.Name;

import javax.persistence.*;

@Table
@Entity
public class BukuKita extends AbstractEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    @Name("title")
    private String title;

    @Column(nullable = false, length = 100)
    @Name("author")
    private String author;

    @Column(nullable = false, length = 100)
    @Name("publisher")
    private String publisher;

    @Column(nullable = false, length = 1)
    @Name("status")
    private boolean status = true;

    @ManyToOne
    @JoinColumn(name = "id_cat", nullable = false)
    private Category category;

    @Column(nullable = false, length = 100)
    @Name("tax")
    private Integer tax;

    @Column(nullable = false, length = 100)
    @Name("shelf")
    private String shelf;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    @Override
    public String toString() {
        return "BukuKita{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", status=" + status +
                ", category=" + category +
                ", tax=" + tax +
                ", shelf='" + shelf + '\'' +
                '}';
    }
}
