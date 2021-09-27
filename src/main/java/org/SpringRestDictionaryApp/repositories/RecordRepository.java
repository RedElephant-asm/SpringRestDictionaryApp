package org.SpringRestDictionaryApp.repositories;

import org.SpringRestDictionaryApp.ORM.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
}
