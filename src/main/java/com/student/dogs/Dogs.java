package com.student.dogs;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Dogs {
    private @Id @GeneratedValue Long id;
    private String breedName;
    private int aveWeight;
    private boolean apartment;

    public Dogs(){

    }

    public Dogs(String breedName, int aveWeight, boolean apartment) {
        this.breedName = breedName;
        this.aveWeight = aveWeight;
        this.apartment = apartment;
    }
}
