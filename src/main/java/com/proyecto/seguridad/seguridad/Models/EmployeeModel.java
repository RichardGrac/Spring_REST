package com.proyecto.seguridad.seguridad.Models;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class EmployeeModel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private AddressModel addressModel;

    public EmployeeModel() {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.mobile = "";
        this.addressModel = null;
    }
}
