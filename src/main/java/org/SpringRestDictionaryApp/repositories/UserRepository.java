package org.SpringRestDictionaryApp.repositories;

import org.SpringRestDictionaryApp.ORM.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /*
        Special methods here.
     */
}
