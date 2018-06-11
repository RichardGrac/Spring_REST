package com.proyecto.seguridad.seguridad.DAO;

import com.proyecto.seguridad.seguridad.Models.EmployeeModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {
    private static ArrayList<EmployeeModel> employees = new ArrayList<>();
    {
        employees.add(new EmployeeModel(101, "John", "Doe", "djohn@gmail.com", "121-232-3435"));
        employees.add(new EmployeeModel(201, "Russ", "Smith", "sruss@gmail.com", "343-545-2345"));
        employees.add(new EmployeeModel(301, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987"));
    }

    public List list(){
        return employees;
    }

    public EmployeeModel get(Long id) {

        for (EmployeeModel c : employees) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public EmployeeModel create(EmployeeModel employee) {
//        employee.setId(System.currentTimeMillis());
//        employee.createDateOfBirth();
        employees.add(employee);
        return employee;
    }

    public Long delete(Long id) {
        for (EmployeeModel c : employees) {
            if (c.getId().equals(id)) {
                employees.remove(c);
                return id;
            }
        }
        return null;
    }

    public EmployeeModel update(Long id, EmployeeModel employee) {
        for (EmployeeModel c : employees) {
            if (c.getId().equals(id)) {
                employee.setId(c.getId());
                employees.remove(c);
                employees.add(employee);
                return employee;
            }
        }
        return null;
    }
}

