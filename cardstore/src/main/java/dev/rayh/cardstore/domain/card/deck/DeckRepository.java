package dev.rayh.cardstore.domain.card.deck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends JpaRepository<DeckEntity, String> {
}
