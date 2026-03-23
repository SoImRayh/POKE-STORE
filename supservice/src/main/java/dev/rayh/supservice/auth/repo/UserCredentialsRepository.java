package dev.rayh.supservice.auth.repo;

import dev.rayh.supservice.auth.domain.UserCredentials;
import dev.rayh.supservice.auth.domain.UserCredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentialsEntity, String> {
        boolean existsByEmail(String email);

    Optional<UserCredentialsEntity> findByEmail(String email);
}
