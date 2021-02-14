package com.enigma.library.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

@MappedSuperclass
public abstract class AbstractEntity<ID> {

    @Column(name = "created_date")
    private LocalDate createDate;

    @Column (name = "modified_data")
    private LocalDate modifiedDate;

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public abstract ID getId();

    public abstract void setId(ID id);

    @PrePersist
    public void prePresist(){
        this.createDate = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.modifiedDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "createDate=" + createDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}