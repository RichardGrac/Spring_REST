package com.proyecto.seguridad.seguridad.Repository;

import com.proyecto.seguridad.seguridad.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface AddressRepository extends JpaRepository<Address, Serializable> {

    Address findById(Integer id);
}
