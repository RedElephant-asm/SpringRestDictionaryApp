package org.SpringRestDictionaryApp.controllers;

import org.SpringRestDictionaryApp.ORM.entities.User;
import org.SpringRestDictionaryApp.controllers.types.EntityController;
import org.SpringRestDictionaryApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController implements EntityController<User> {

    @Autowired
    private UserService service;

    @Override
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getById(int id) {
        return service.getById(id);
    }
}
