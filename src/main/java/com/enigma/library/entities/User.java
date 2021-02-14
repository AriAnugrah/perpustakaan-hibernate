package com.enigma.library.entities;


import jdk.jfr.Name;

import javax.persistence.*;

@Table
@Entity
public class User extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    @Name("name")
    private String name;

    @Column(nullable = false, length = 100)
    @Name("gender")
    private String gender;

    @Column(nullable = false, length = 100)
    @Name("address")
    private String address;

    @Column(nullable = false, length = 100)
    @Name("phone_num")
    private String phone_num;

    @Column(nullable = false, length = 1)
    @Name("status_loan")
    private boolean status_loan = true;

    @Column(nullable = false, length = 1)
    @Name("status_delete")
    private boolean status_delete = true;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public boolean isStatus_loan() {
        return status_loan;
    }

    public void setStatus_loan(boolean status_loan) {
        this.status_loan = status_loan;
    }

    public boolean isStatus_delete() {
        return status_delete;
    }

    public void setStatus_delete(boolean status_delete) {
        this.status_delete = status_delete;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", status_loan=" + status_loan +
                ", status_delete=" + status_delete +
                '}';
    }
}
