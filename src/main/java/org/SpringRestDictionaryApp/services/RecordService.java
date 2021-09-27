package org.SpringRestDictionaryApp.services;

import org.SpringRestDictionaryApp.ORM.entities.Record;
import org.SpringRestDictionaryApp.repositories.RecordRepository;
import org.SpringRestDictionaryApp.services.models.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecordService extends EntityService<Record, RecordRepository> {

    private static final Record UNKNOWN_RECORD = new Record(0, "UNKNOWN_RECORD.description");

    public RecordService(@Autowired @Qualifier("recordRepository")RecordRepository mainRepository){
        super(mainRepository);
    }

    @Override
    public Record getById(int id) {
        Optional<Record> searchResult = super.mainRepository.findById(id);
        return searchResult.orElse(UNKNOWN_RECORD);
    }
}
