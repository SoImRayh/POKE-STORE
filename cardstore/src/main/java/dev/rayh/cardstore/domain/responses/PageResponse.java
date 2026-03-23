package dev.rayh.cardstore.domain.responses;


import java.util.List;

public record PageResponse<T>(
        List<T> content,
        int page,
        int pageSize,
        Long totalElements,
        int totalPages
) { }
