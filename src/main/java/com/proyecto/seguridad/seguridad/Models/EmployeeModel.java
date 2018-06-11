package com.proyecto.seguridad.seguridad.Models;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class EmployeeModel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
}
