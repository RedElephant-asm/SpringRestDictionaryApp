package org.SpringRestDictionaryApp.ORM.models;

import javax.persistence.*;

@MappedSuperclass
public class Main {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    public Main() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
