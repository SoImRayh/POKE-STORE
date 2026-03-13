package dev.rayh.cardstore.domain.card.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum SuperType {
    POKEMON("Pokémon"),
    ENERGY("Energy"),
    TRAINER("Trainer");
    

    private String description;


    private SuperType (String description){
        this.description = description;
    }

    @JsonValue
    public String getValue(){
        return description;
    }
    @JsonCreator
    static SuperType fromDescription(String description){
        for (SuperType st : SuperType.values()){
            if (st.description.equalsIgnoreCase(description)) {
                return st;
            }
        }
        throw new IllegalArgumentException("No Value found");
    }

}
