package com.proyecto.seguridad.seguridad.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Address")
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_add", unique = true, nullable = false)
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "colony")
    private String colony;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "country")
    private String country;

    @Column(name = "secKey", nullable = false)
    private String secKey;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Employee employeee;

    public Address() {
        this.street = "";
        this.number = "";
        this.colony = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.country = "";
        this.secKey = "";
        this.employeee = null;
    }

    /* Personal toString() in order to don't get a infinite loop printing 'employee'. */
    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", colony='" + colony + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", employeee.id=" + employeee.getId() +
                '}';
    }
}
