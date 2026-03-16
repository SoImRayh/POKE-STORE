package dev.rayh.cardstore.service.imp;


import java.util.List;

import dev.rayh.cardstore.domain.card.entity.CardEntity;
import dev.rayh.cardstore.domain.card.set.SetEntity;
import dev.rayh.cardstore.domain.card.set.SetRepository;
import dev.rayh.cardstore.domain.factory.SetFactory;
import dev.rayh.cardstore.exception.NoRecordFoundexception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dev.rayh.cardstore.domain.card.model.Card;
import dev.rayh.cardstore.domain.factory.CardFactory;
import dev.rayh.cardstore.repository.CardRepository;
import dev.rayh.cardstore.service.CardService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImp implements CardService {

    private final CardRepository repository;
    private final FileStorageServiceImp fileStorageService;
    private final SetRepository setRepository;

    public ResponseEntity handleGetAll(){

        List<Card> cards = repository.findAll().stream().map(
            entity -> CardFactory.modelFromEntity(entity)
        ).toList();


        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @Override
    public ResponseEntity handleGetById(String id) {

        Card c = CardFactory.modelFromEntity(
                repository.findById(id).orElseThrow(() -> new NoRecordFoundexception("Not found"))
        );
        
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @Override
    public ResponseEntity handleGetByName(String name) {
        
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @Override
    public ResponseEntity handleCreate(Card card) {
        CardEntity entity = CardFactory.entityFromModel(card);

        card = CardFactory.modelFromEntity(repository.save(entity));

        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @Override
    public ResponseEntity handleUpdate(String name, Card card) {
        return null;
    }

    @Override
    public ResponseEntity handleDelete(Card card) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDelete'");
    }

    public ResponseEntity handleSetImage(String name, MultipartFile img) {

        return new ResponseEntity<>("a", HttpStatus.OK);
    }

    @Override
    public ResponseEntity saveOne(Card c) {
        var ent = CardFactory.entityFromModel(c);

        ent = repository.save(ent);

        return new ResponseEntity(CardFactory.modelFromEntity(ent), HttpStatus.OK);

    }

    public ResponseEntity handleSaveAll(String setId, List<Card> models) {
        SetEntity set;

        set = setRepository.findById(setId).orElseThrow(() ->
                new NoRecordFoundexception("Not fouded set with this ID")
        );

        models.forEach(card -> card.setSet(SetFactory.modelFromEntity(set)));

        repository.saveAll(models.stream().map(CardFactory::entityFromModel).toList());

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    

}
