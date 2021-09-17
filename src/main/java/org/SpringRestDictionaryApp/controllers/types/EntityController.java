package org.SpringRestDictionaryApp.controllers.types;

import java.util.List;

public interface EntityController<EntityType> {

    List<EntityType> getAll();

    EntityType getById(int id);

}
