package org.SpringRestDictionaryApp.services.types;

import org.SpringRestDictionaryApp.ORM.entities.Dictionary;
import org.SpringRestDictionaryApp.ORM.models.MainModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public abstract class EntityService<Entity extends MainModel, EntityRepository extends JpaRepository<Entity, Integer> > {

    protected EntityRepository mainRepository;

    public EntityService(EntityRepository entityRepository){
        this.mainRepository = entityRepository;
    }

    public List<Entity> getAll(){
        return mainRepository.findAll();
    }

    public abstract Entity getById(int id);
}