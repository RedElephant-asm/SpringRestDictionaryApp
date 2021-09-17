package org.SpringRestDictionaryApp.services;

import org.SpringRestDictionaryApp.ORM.entities.Dictionary;
import org.SpringRestDictionaryApp.repositories.DictionaryRepository;
import org.SpringRestDictionaryApp.services.models.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DictionaryService extends EntityService<Dictionary, DictionaryRepository> {

    private static final Dictionary UNKNOWN_DICTIONARY = new Dictionary(0, "UNKNOWN_DICTIONARY.description");

    public DictionaryService(@Autowired @Qualifier("dictionaryRepository") DictionaryRepository mainRepository) {
        super(mainRepository);
    }

    @Override
    public Dictionary getById(int id) {
        Optional<Dictionary> searchResult = super.mainRepository.findById(id);
        return searchResult.orElse(UNKNOWN_DICTIONARY);
    }
}
