package dev.rayh.cardstore.service;

import dev.rayh.cardstore.domain.dto.CardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import dev.rayh.cardstore.domain.card.model.Card;

import java.util.List;

public interface CardService {

    ResponseEntity handleGetAll();
    ResponseEntity handleGetById(String id);
    ResponseEntity handleCreate(Card card);
    ResponseEntity handleUpdate(String name, Card card);
    ResponseEntity handleDelete(Card card);
    ResponseEntity handleGetByName(String name);
    ResponseEntity handleSetImage(String name, MultipartFile img);

    ResponseEntity saveOne(Card c);
    ResponseEntity handleSaveAll(String setId, List<Card> models);
}
