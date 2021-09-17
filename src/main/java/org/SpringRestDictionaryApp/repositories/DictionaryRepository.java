package org.SpringRestDictionaryApp.repositories;

import org.SpringRestDictionaryApp.ORM.entities.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> {
    /*
        Special methods here.
     */
}
