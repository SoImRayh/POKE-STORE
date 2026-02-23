package dev.rayh.cardstore.domain.dto;

public record ErrorResponseDto (
        String time,
        int status,
        String message,
        String path
){
}
