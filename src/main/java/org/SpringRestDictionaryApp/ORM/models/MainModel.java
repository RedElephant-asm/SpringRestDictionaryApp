package org.SpringRestDictionaryApp.ORM.models;

import javax.persistence.*;

@MappedSuperclass
public abstract class MainModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    public MainModel() {
    }

    public MainModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
