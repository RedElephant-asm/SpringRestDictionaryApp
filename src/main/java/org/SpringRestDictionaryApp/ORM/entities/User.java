package org.SpringRestDictionaryApp.ORM.entities;

import org.SpringRestDictionaryApp.ORM.models.MainModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "dictionaryrest", name = "Users")
public class User extends MainModel {

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    public User(int id, String name, String password) {
        super(id);
        this.name = name;
        this.password = password;
    }
}
