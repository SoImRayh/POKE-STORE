package dev.rayh.cardstore.domain;

import lombok.Getter;

@Getter
public enum SuperType {

    TRAINER("trainer");
    

    private String description;


    private SuperType (String description){
        this.description = description;
    }

}
