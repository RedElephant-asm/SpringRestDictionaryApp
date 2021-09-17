package org.SpringRestDictionaryApp.controllers;

import org.SpringRestDictionaryApp.ORM.entities.Dictionary;
import org.SpringRestDictionaryApp.controllers.types.EntityController;
import org.SpringRestDictionaryApp.services.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dictionaries")
public class DictionaryController implements EntityController<Dictionary> {

    @Autowired
    private DictionaryService service;

    @Override
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dictionary> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dictionary getById(int id) {
        return service.getById(id);
    }
}
