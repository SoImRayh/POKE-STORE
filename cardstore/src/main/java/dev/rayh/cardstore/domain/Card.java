package dev.rayh.cardstore.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "card")
@Data
public class Card {
    @Id
    private String id;
    private String name;
    private String serie;
    private String ilustrator;
    private String description;
    private SuperType type;
    private String imageUrl;


    public void createId() {
        if (this.name != null && this.serie != null) {
            this.id =  String.format("%s %s", this.name, this.serie);
        }
    }
}
