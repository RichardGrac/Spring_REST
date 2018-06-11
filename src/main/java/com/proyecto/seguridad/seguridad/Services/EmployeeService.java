package com.proyecto.seguridad.seguridad.Services;

//import com.proyecto.seguridad.seguridad.Converters.AddressConverter;
import com.proyecto.seguridad.seguridad.Converters.EmployeeConverter;
//import com.proyecto.seguridad.seguridad.Entities.Address;
import com.proyecto.seguridad.seguridad.Entities.Employee;
//import com.proyecto.seguridad.seguridad.Models.AddressModel;
import com.proyecto.seguridad.seguridad.Models.EmployeeModel;
import com.proyecto.seguridad.seguridad.Repository.EmployeeRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("employeeService")
public class EmployeeService {

    private static final Log LOG = LogFactory.getLog(EmployeeService.class);

    @Autowired
    private EmployeeConverter employeeConverter;

//    @Autowired
//    private AddressConverter addressConverter;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeModel> getAllEmployees(){
        LOG.info("METHOD: getAllEmployees()");
        List<EmployeeModel> employeeModels = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()){
            System.out.println("--- printing employ --->>> " + employee.toString());
            employeeModels.add(employeeConverter.entityToModel(employee));
        }
        return employeeModels;
    }

    public EmployeeModel addEmployee(EmployeeModel employeeModel){
        LOG.info("METHOD: addEmployee() --PARAMS: employeeModel=" + employeeModel);
        return employeeConverter
                .entityToModel(employeeRepository.save(employeeConverter.modelToEntity(employeeModel)));
    }

    public EmployeeModel getEmployee(Integer id) {
        LOG.info("METHOD: getEmployee() --PARAMS: id=" + id);
        try {
            return employeeConverter.entityToModel(employeeRepository.findById(id));
        }catch (Exception e){
            // If the Employee doesn't exists.
            return null;
        }
    }

    public void removeEmployee(Integer id){
        LOG.info("METHOD: removeEmployee() --PARAMS: id=" + id);
        employeeRepository.deleteById(id);
    }

    public EmployeeModel updateEmployee(EmployeeModel employeeModel){
        LOG.info("METHOD: updateEmployee() --PARAMS: employeeModel=" + employeeModel);
        return employeeConverter
                .entityToModel(employeeRepository.save(employeeConverter.modelToEntity(employeeModel)));
    }
}
