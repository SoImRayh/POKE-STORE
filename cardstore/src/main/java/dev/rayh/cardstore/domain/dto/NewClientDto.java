package dev.rayh.cardstore.domain.dto;


public record NewClientDto(
    String cpfOrCnpj,
    String email,
    String fantasyName,
    String phone,
    String socialname
) {
} 
