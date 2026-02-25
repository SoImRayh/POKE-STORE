package dev.rayh.cardstore.service.imp;


import java.util.List;
import java.util.Optional;

import javax.swing.text.html.parser.Entity;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dev.rayh.cardstore.domain.card.Card;
import dev.rayh.cardstore.domain.factory.CardFactory;
import dev.rayh.cardstore.entity.CardEntity;
import dev.rayh.cardstore.repository.CardRepository;
import dev.rayh.cardstore.service.CardService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImp implements CardService {

    private final CardRepository repository;
    private final FileStorageServiceImp fileStorageService;

    public ResponseEntity handleGetAll(){

        List<Card> cards = repository.findAll().stream().map(
            entity -> CardFactory.fromEntity(entity)
        ).toList();


        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @Override
    public ResponseEntity handleGetById(String id) {
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity handleGetByName(String name) {
        
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @Override
    public ResponseEntity handleCreate(Card card) {
        CardEntity entity = CardFactory.fromModel(card);

        card = CardFactory.fromEntity(repository.save(entity));

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

    public ResponseEntity handleSaveAll(List<Card> models) {

        List<CardEntity> entities = models.stream().map( m -> CardFactory.fromModel(m)).toList();

        models = repository.saveAll(entities).stream().map(e -> CardFactory.fromEntity(e)).toList();

        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    

}
