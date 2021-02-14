package com.enigma.library.entities;


import jdk.jfr.Name;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
public class Borrow extends AbstractEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private LocalDate sendbackdate;

    @Column(nullable = false, length = 100)
    @Name("fee")
    private Integer fee;

    @Column(nullable = false, length = 1)
    @Name("status_active")
    private boolean status_active = true;

    @ManyToOne
    @JoinColumn(name = "id_book", nullable = false)
    private BukuKita bukuKita;

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getSendbackdate() {
        return sendbackdate;
    }

    public void setSendbackdate(LocalDate sendbackdate) {
        this.sendbackdate = sendbackdate;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public BukuKita getBukuKita() {
        return bukuKita;
    }

    public void setBukuKita(BukuKita bukuKita) {
        this.bukuKita = bukuKita;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus_active() {
        return status_active;
    }

    public void setStatus_active(boolean status_active) {
        this.status_active = status_active;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", sendbackdate=" + sendbackdate +
                ", fee=" + fee +
                ", status_active=" + status_active +
                ", bukuKita=" + bukuKita +
                ", user=" + user +
                '}';
    }
}
