package dev.rayh.cardstore.integrations.redis.impl;

import dev.rayh.cardstore.exception.NewAccountException;
import dev.rayh.cardstore.integrations.redis.RedisService;
import dev.rayh.contracts.EmailEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RedisServiceImp implements RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public UUID saveToken(String accountEmail) {
        var uuid = UUID.randomUUID();
        redisTemplate.opsForValue().set(uuid.toString(), accountEmail, Duration.ofMinutes(5));
        return uuid;
    }

    @Override
    public String validateToken(String token) {
        String email  = redisTemplate.opsForValue().get(token);
        if ( email != null)
            return email;
        throw new NewAccountException("Registro nao encontrado ou expirado!");
    }

    @Override
    public void deleteToken(String token) {
        redisTemplate.delete(token);
    }
}
