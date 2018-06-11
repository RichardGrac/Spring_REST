package com.proyecto.seguridad.seguridad.Converters;

import com.proyecto.seguridad.seguridad.Entities.Employee;
import com.proyecto.seguridad.seguridad.Models.EmployeeModel;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public Employee modelToEntity(EmployeeModel employeeModel){
        Employee employee = new Employee();
        employee.setId(employeeModel.getId());
        employee.setFirstName(employeeModel.getFirstName());
        employee.setLastName(employeeModel.getLastName());
        employee.setEmail(employeeModel.getEmail());
        employee.setMobile(employeeModel.getMobile());
        return employee;
    }

    public EmployeeModel entityToModel(Employee employee){
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(employee.getId());
        employeeModel.setFirstName(employee.getFirstName());
        employeeModel.setLastName(employee.getLastName());
        employeeModel.setEmail(employee.getEmail());
        employeeModel.setMobile(employee.getMobile());
        return employeeModel;
    }
}
