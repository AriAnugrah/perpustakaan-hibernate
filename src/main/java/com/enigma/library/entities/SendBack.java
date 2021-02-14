package com.enigma.library.entities;

import jdk.jfr.Name;

import javax.persistence.*;

@Table
@Entity
public class SendBack extends AbstractEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true, length = 100)
    @Name("exceed_dur")
    private Integer exceed_dur;

    @Column(nullable = true, length = 100)
    @Name("fine")
    private Integer fine;

    @Column(nullable = true, length = 100)
    @Name("fineNeedPay")
    private Integer fineNeedPay;

    @Column(nullable = true, length = 100)
    @Name("tax")
    private Integer tax;

    @OneToOne
    @JoinColumn(name = "id_borrow", nullable = false)
    private Borrow borrow;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public Integer getExceed_dur() {
        return exceed_dur;
    }

    public void setExceed_dur(Integer exceed_dur) {
        this.exceed_dur = exceed_dur;
    }

    public Integer getFine() {
        return fine;
    }

    public void setFine(Integer fine) {
        this.fine = fine;
    }

    public Integer getFineNeedPay() {
        return fineNeedPay;
    }

    public void setFineNeedPay(Integer fineNeedPay) {
        this.fineNeedPay = fineNeedPay;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "SendBack{" +
                "id=" + id +
                ", exceed_dur=" + exceed_dur +
                ", fine=" + fine +
                ", fineNeedPay=" + fineNeedPay +
                ", tax=" + tax +
                ", borrow=" + borrow +
                '}';
    }
}
