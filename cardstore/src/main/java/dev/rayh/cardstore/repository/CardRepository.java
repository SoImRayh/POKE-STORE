package dev.rayh.cardstore.repository;

import java.util.List;
import java.util.UUID;

import dev.rayh.cardstore.domain.card.entity.CardEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, String> {

    @Cacheable(value = "card")
    public List<CardEntity> findAll();
}
