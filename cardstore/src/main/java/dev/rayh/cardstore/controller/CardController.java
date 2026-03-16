package dev.rayh.cardstore.controller;

import java.util.List;

import dev.rayh.cardstore.domain.dto.CardDto;
import dev.rayh.cardstore.domain.factory.CardFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dev.rayh.cardstore.domain.card.model.Card;
import dev.rayh.cardstore.service.imp.CardServiceImp;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/card")
public class CardController {

    
    private final CardServiceImp service;


    @GetMapping("/get")
    public ResponseEntity handleGet(){
        return  service.handleGetAll();
    }

    @GetMapping("/get/one")
    public ResponseEntity handleGetById(@RequestParam String id){
        return service.handleGetById(id);
    }

    @GetMapping("/get/find/{name}")
    public ResponseEntity handleGetByName(@PathVariable String name){
        return service.handleGetByName(name);
    }

    @PutMapping("/update")
    public ResponseEntity handleUpdate(@RequestBody Card card, @RequestParam String name){
        return service.handleUpdate(name, card);
    }

    @PutMapping("/setimage")
    public ResponseEntity handleSetImage(@RequestParam String name, @RequestParam("img") MultipartFile img){
        return service.handleSetImage(name, img);
    }

    @PostMapping("/create")
    public ResponseEntity handleCreate(@RequestBody Card card){
        return service.handleCreate(card);
    }

    @PostMapping("/saveall")
    public ResponseEntity saveAllEntity(@RequestParam String setId,@RequestBody List<Card> records) {
        return service.handleSaveAll(setId, records);
    }
    
    @PostMapping("/test")
    public ResponseEntity test(@RequestBody Card c){
        return service.saveOne(c);


    }
}
