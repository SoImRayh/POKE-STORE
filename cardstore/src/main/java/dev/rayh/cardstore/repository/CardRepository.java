package dev.rayh.cardstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rayh.cardstore.domain.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
    Card save(Card card);
    Optional<Card> findById(String id);
    List<Card> findAll();
    List<Card> findByName(String name);

}
