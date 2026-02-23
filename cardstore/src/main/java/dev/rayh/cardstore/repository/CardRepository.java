package dev.rayh.cardstore.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rayh.cardstore.domain.card.Card;
import dev.rayh.cardstore.entity.CardEntity;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, UUID> {

}
