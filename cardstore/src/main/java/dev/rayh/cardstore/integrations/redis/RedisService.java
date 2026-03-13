package dev.rayh.cardstore.integrations.redis;

import java.util.UUID;

public interface RedisService {
    UUID saveToken(String event);
    String validateToken(String token);
    void deleteToken(String token);
}
