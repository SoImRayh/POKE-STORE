package dev.rayh.cardstore.repository;

import dev.rayh.cardstore.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {
    boolean existsByEmail(String email);
}
