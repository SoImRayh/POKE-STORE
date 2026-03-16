package dev.rayh.cardstore.domain.card.set.impl;

import dev.rayh.cardstore.domain.card.set.Set;
import dev.rayh.cardstore.domain.card.set.SetRepository;
import dev.rayh.cardstore.domain.card.set.SetService;
import dev.rayh.cardstore.domain.factory.SetFactory;
import dev.rayh.cardstore.exception.NoRecordFoundexception;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetServiceImpl implements SetService {

    private final SetRepository repository;
    @Override
    public ResponseEntity saveOne(Set set) {

        var entity = SetFactory.entityFromModel(set);
        entity = repository.save(entity);
        return new ResponseEntity(entity, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity getOne(String setId) {

        Set set = SetFactory.modelFromEntity(
                repository.findById(setId).orElseThrow(() -> new NoRecordFoundexception("no founded"))
        );

        return new ResponseEntity(set, HttpStatus.OK) ;
    }
}
