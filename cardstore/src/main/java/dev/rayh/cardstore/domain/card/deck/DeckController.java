package dev.rayh.cardstore.domain.card.deck;

import dev.rayh.cardstore.domain.card.deck.impl.DeckServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deck")
@RequiredArgsConstructor
class DeckController {

    private final DeckServiceImpl service;

    @PostMapping("/save")
    public ResponseEntity saveOne(@RequestBody Deck deck){
        return service.saveOne(deck);
    }

    @GetMapping("/get")
    public ResponseEntity getOne(@RequestParam String id){
        return service.getOne(id);
    }

    @GetMapping("/getall")
    public ResponseEntity getAll(){
        return service.getAll();
    }
}
