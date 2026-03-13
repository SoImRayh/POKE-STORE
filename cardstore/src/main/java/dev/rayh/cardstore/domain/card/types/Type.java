package dev.rayh.cardstore.domain.card.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {
    PSYCHIC("Psychic"),
    WATER("Water"),
    COLORLESS("Colorless"),
    FIRE("Fire"),
    FIGHTING("Fighting"),
    LIGHTNING("Lightning"),
    GRASS("Grass"),
    METAL("Metal"),
    DARKNESS("Darkness"),
    DRAGON("Dragon"),
    FAIRY("Fairy");

    private final String description;

    private Type (String description){
        this.description = description;
    }

    @JsonValue
    public String getDescription(){
        return this.description;
    }

    @JsonCreator
    public Type fromDescription(String val){
        for (Type t : Type.values()){
            if (t.description.equalsIgnoreCase(val))
                return t;
        }

        throw new IllegalArgumentException("Value not found");
    }
}
