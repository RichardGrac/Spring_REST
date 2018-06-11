package com.proyecto.seguridad.seguridad.Repository;

import com.proyecto.seguridad.seguridad.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {
    Employee findById(Integer id);

    @Transactional
    void deleteById(Integer id);
}
