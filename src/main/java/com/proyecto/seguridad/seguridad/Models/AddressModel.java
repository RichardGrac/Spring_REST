package com.proyecto.seguridad.seguridad.Models;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class AddressModel {
    private Integer id;
    private String street;
    private String  number;
    private String colony;
    private String city;
    private String state;
    private String zip;
    private String country;

    public AddressModel() {
        this.id = 0;
        this.street = "";
        this.number = "";
        this.colony = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.country = "";
    }

    public AddressModel(String street, String number, String colony, String city, String state, String zip, String country) {
        this.street = street;
        this.number = number;
        this.colony = colony;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }
}
