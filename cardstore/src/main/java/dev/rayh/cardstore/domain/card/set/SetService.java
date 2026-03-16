package dev.rayh.cardstore.domain.card.set;

import org.springframework.http.ResponseEntity;

public interface SetService {
    ResponseEntity saveOne(Set set);

    ResponseEntity getOne(String setId);
}
