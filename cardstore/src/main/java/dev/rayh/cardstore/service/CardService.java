package dev.rayh.cardstore.service;

import dev.rayh.cardstore.domain.responses.PageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import dev.rayh.cardstore.domain.card.model.Card;

public interface CardService {

    ResponseEntity<PageResponse<Card>> handleGetAll(int pageSize, int pageIndex);
    ResponseEntity handleGetById(String id);
    ResponseEntity handleCreate(Card card);
    ResponseEntity handleUpdate(String name, Card card);
    ResponseEntity handleDelete(Card card);
    ResponseEntity handleGetByName(String name);
    ResponseEntity handleSetImage(String name, MultipartFile img);

    ResponseEntity saveOne(Card c);
}
