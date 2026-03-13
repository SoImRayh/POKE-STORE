package dev.rayh.cardstore.domain.card.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SubType {
    STAGE1("Stage 1"),
    STAGE2("Stage 2"),
    BASIC("Basic"),
    SPECIAL("Special"),
    ROCKET_SECRET_MACHINE("Rocket's Secret Machine"),
    BABY("Baby"),
    STADIUM("Stadium"),
    ITEM("Item"),
    SUPPORTER("Supporter"),
    TEAM_PLASMA("Team Plasma"),
    RESTORED("Restored"),
    EX("EX"),
    POKEMON_TOOL("Pokémon Tool"),
    ACE_SPEC("ACE SPEC"),
    V("V"),
    VMAX("VMAX"),
    STAR("Star"),
    LEVEL_UP("Level-Up"),
    SP("SP"),
    PRIME("Prime"),
    MEGA("MEGA"),
    GX("GX"),
    TECHNICAL_MACHINE("Technical Machine"),
    LEGEND("LEGEND"),
    TERA("Tera"),
    GOLDENROD_GAME_CORNER("Goldenrod Game Corner"),
    RADIANT("Radiant"),
    VSTAR("VSTAR"),
    TAG_TEAM("TAG TEAM"),
    ULTRA_BEAST("Ultra Beast"),
    PRISM_STAR("Prism Star"),
    FUTURE("Future"),
    ANCIENT("Ancient"),
    FUSION_STRIKE("Fusion Strike"),
    SINGLE_STRIKE("Single Strike"),
    RAPID_STRIKE("Rapid Strike"),
    ETERNAMAX("Eternamax"),
    V_UNION("V-UNION"),
    BREAK("BREAK"),
    POKEMON_TOOL_F("Pokémon Tool F"),

    ;

    private final String description;

    SubType (String desc){
        this.description = desc;
    }

    @JsonValue
    public String getDescription(){
        return this.description;
    }

    @JsonCreator
    public static SubType fromDescription(String value){
        for (SubType type : SubType.values()){
            if (type.getDescription().equalsIgnoreCase(value))
                return type;

        }
        throw new IllegalArgumentException("No Equivalent value found");

    }
}
