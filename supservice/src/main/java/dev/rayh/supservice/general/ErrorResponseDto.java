package dev.rayh.supservice.general;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        String message,
        LocalDateTime date
) {
}
