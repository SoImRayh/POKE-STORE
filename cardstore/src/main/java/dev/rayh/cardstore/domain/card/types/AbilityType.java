package dev.rayh.cardstore.domain.card.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AbilityType {
    POKEMON_POWER("Pokémon Power"),
    POKE_BODY("Poké-Body"),
    ABILITY("Ability"),
    POKE_POWER("Poké-Power");

    private String description;

    private AbilityType (String val){
        this.description = val;
    }

    @JsonValue
    public String getDescription(){
        return this.description;
    }

    @JsonCreator
    public AbilityType fromDescription(String val){
        for (AbilityType t : AbilityType.values()){
            if (t.description.equalsIgnoreCase(val))
                return  t;
        }
        throw new IllegalArgumentException("Value not found");
    }
    
}
