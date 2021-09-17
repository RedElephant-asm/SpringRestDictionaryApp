package org.SpringRestDictionaryApp.ORM.entities;

import org.SpringRestDictionaryApp.ORM.models.MainModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "dictionaryrest", name = "Dictionaries")
public class Dictionary extends MainModel {

    @Column(name = "name")
    private String description;

    public Dictionary(int id, String description) {
        super(id);
        this.description = description;
    }

    public String getName() {
        return description;
    }

    public void setName(String description) {
        this.description = description;
    }
}
