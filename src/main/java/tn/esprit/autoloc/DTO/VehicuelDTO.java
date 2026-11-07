package tn.esprit.autoloc.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VehicuelDTO {
    private String immatriculation;
    private String marque;
    private String modele;

    public VehicuelDTO(String immatriculation,
                       String marque,
                       String modele) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;

    }
}