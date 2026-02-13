package dev.rayh.cardstore.service.imp;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dev.rayh.cardstore.domain.Card;
import dev.rayh.cardstore.repository.CardRepository;
import dev.rayh.cardstore.service.CardService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImp implements CardService {

    private final CardRepository repository;
    private final FileStorageServiceImp fileStorageService;

    public ResponseEntity handleGetAll(){
        Iterable<Card> cards = repository.findAll();

        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @Override
    public ResponseEntity handleGetById(String id) {
        var card = repository.findById(id);
        if (card.isPresent()) {
            return new ResponseEntity<>(card.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity handleGetByName(String name) {
        var cards = repository.findByName(name);
        if (cards.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @Override
    public ResponseEntity handleCreate(Card card) {

        card.createId();

        repository.save(card);

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

        List<Card> c = repository.findByName(name);

        if (c.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String path = fileStorageService.storeFile(img);

        if (path == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        var cardToUpdate = c.get(0);
        cardToUpdate.setImageUrl(path);
        repository.save(cardToUpdate);

        return new ResponseEntity<>(cardToUpdate, HttpStatus.OK);
    }

    

}
