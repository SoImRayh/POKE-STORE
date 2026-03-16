package dev.rayh.cardstore.domain.card.set;

import dev.rayh.cardstore.domain.card.set.impl.SetServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/set")
@RequiredArgsConstructor
public class SetController {

    private final SetServiceImpl service;
    @PostMapping("/save")
    public ResponseEntity saveOne(@RequestBody Set set){
        return service.saveOne(set);
    }

    @GetMapping("get")
    public ResponseEntity getOne(@RequestParam String id){
        return service.getOne(id);

    }
}
