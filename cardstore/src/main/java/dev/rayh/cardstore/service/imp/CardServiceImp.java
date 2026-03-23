package dev.rayh.cardstore.service.imp;


import java.util.List;

import dev.rayh.cardstore.domain.card.entity.CardEntity;
import dev.rayh.cardstore.domain.responses.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public ResponseEntity<PageResponse<Card>> handleGetAll(int pageSize, int pageIndex){

        Page<CardEntity> entities = repository.findAll(PageRequest.of(pageIndex, pageSize));

        PageResponse<Card> pr = new PageResponse<>(
                entities.map(CardFactory::fromEntity).toList(),
                entities.getNumber(),
                entities.getSize(),
                entities.getTotalElements(),
                entities.getTotalPages()
        );

        return new ResponseEntity<>(pr, HttpStatus.OK);
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

    @Override
    public ResponseEntity saveOne(Card c) {
        var ent = CardFactory.fromModel(c);

        ent = repository.save(ent);

        return new ResponseEntity(CardFactory.fromEntity(ent), HttpStatus.OK);

    }

    public ResponseEntity handleSaveAll(List<Card> models) {

        List<CardEntity> entities = models.stream().map(m -> CardFactory.fromModel(m)).toList();

        models = repository.saveAll(entities).stream().map(e -> CardFactory.fromEntity(e)).toList();

        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    

}
