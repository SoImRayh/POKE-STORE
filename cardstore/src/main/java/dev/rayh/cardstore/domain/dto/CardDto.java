package dev.rayh.cardstore.domain.dto;

import java.util.List;
import java.util.Map;

public record CardDto(
        String id,
        String name,
        String hp,
        String number,
        String artist,
        String rarity,
        String bigImage,
        String minorImage
) {
}
