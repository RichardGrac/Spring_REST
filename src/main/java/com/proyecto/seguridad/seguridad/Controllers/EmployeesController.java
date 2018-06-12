package com.proyecto.seguridad.seguridad.Controllers;

import com.proyecto.seguridad.seguridad.Models.AddressModel;
import com.proyecto.seguridad.seguridad.Models.EmployeeModel;
import com.proyecto.seguridad.seguridad.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeModel> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable("id") Integer id) {
        EmployeeModel employee = employeeService.getEmployee(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>
                (returnMessage("No Employee found for ID " + id), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/employees")
    public ResponseEntity createEmployee(EmployeeModel employeeModel){
        EmployeeModel newEmployee = employeeService.addEmployee(employeeModel);
        if (newEmployee != null){
            return new ResponseEntity<>(newEmployee, HttpStatus.OK);
        }
        return new ResponseEntity<>(returnMessage("Could not add a new Employee."), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        if (employeeService.getEmployee(id) != null) {
            employeeService.removeEmployee(id);
            return new ResponseEntity<>(returnMessage("Employee with id '" + id + "' deleted"), HttpStatus.OK);
        }
        return new ResponseEntity<>(returnMessage("No Employee found for ID " + id), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/employees")
    public ResponseEntity updateEmployee(EmployeeModel employee) {
        employee = employeeService.updateEmployee(employee);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>(returnMessage("Could not update your Employee"), HttpStatus.BAD_REQUEST);
    }

    private String returnMessage(String message){
        return  "{\"message\": \"" + message + "\"}";
    }

}
