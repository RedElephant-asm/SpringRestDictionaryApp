package org.SpringRestDictionaryApp.ORM.entities;

import org.SpringRestDictionaryApp.ORM.models.MainModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "dictionaryrest", name = "Records")
public class Record extends MainModel {

    @Column(name = "content")
    private String content;

    public Record(int id, String content){
        super(id);
        this.content = content;
    }

    public Record(){

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
