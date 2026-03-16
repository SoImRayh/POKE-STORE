package dev.rayh.cardstore.domain.dto;

import dev.rayh.cardstore.domain.card.model.*;
import dev.rayh.cardstore.domain.card.set.Set;
import dev.rayh.cardstore.domain.card.types.SubType;
import dev.rayh.cardstore.domain.card.types.SuperType;
import dev.rayh.cardstore.domain.card.types.Type;

import java.util.List;
import java.util.Map;

import static org.aspectj.apache.bcel.Constants.types;

public record CardDto(
         String id,
         String name,
         SuperType supertype,
         List<SubType> subtypes,
         String hp,
         List<Type> types,
         List<String> evolvesTo,
         String evolvesFrom,
         List<Ability> abilities,
         List<Attack> attacks,
         List<Weakness> weaknesses,
         List<Type> retreatCost,
         Integer convertedRetreatCost,
         String number,
         String artist,
         String rarity,
         String flavorText,
         List<Integer> nationalPokedexNumbers,
         Legality legalities,
         String regulationMark,
         ImageData images,
         String set

) {
}
