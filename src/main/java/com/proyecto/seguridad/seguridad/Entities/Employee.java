package com.proyecto.seguridad.seguridad.Entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Employee")
@AllArgsConstructor
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Getter @Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_emp", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "secKey", nullable = false)
    private String secKey;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_add")
    private Address address;
}
