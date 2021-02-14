package com.enigma.library.entities;

import jdk.jfr.Name;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;



@Table
@Entity
public class Category extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    @Name("name_cat")
    private String name_cat;

    @Column(nullable = false, length = 100)
    @Name("rent_price")
    private Integer rent_price;

    @Column(nullable = false, length = 100)
    @Name("rent_duration")
    private Integer rent_duration;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_cat() {
        return name_cat;
    }

    public void setName_cat(String name_cat) {
        this.name_cat = name_cat;
    }

    public Integer getRent_price() {
        return rent_price;
    }

    public void setRent_price(Integer rent_price) {
        this.rent_price = rent_price;
    }

    public Integer getRent_duration() {
        return rent_duration;
    }

    public void setRent_duration(Integer rent_duration) {
        this.rent_duration = rent_duration;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name_cat='" + name_cat + '\'' +
                ", rent_price=" + rent_price +
                ", rent_duration=" + rent_duration +
                '}';
    }
}
