package org.SpringRestDictionaryApp.services.models;

import org.SpringRestDictionaryApp.ORM.models.MainModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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