package dev.rayh.cardstore.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import dev.rayh.cardstore.domain.card.Card;

public interface CardService {

    ResponseEntity handleGetAll();
    ResponseEntity handleGetById(String id);
    ResponseEntity handleCreate(Card card);
    ResponseEntity handleUpdate(String name, Card card);
    ResponseEntity handleDelete(Card card);
    ResponseEntity handleGetByName(String name);
    ResponseEntity handleSetImage(String name, MultipartFile img);

}
