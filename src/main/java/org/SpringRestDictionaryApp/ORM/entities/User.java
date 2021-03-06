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

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
