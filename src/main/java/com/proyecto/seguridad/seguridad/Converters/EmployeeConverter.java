package com.proyecto.seguridad.seguridad.Converters;

import com.proyecto.seguridad.seguridad.Entities.Employee;
import com.proyecto.seguridad.seguridad.Models.EmployeeModel;
import com.proyecto.seguridad.seguridad.Security.AESEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;

@Component
public class EmployeeConverter {

    @Autowired
    @Qualifier("addressConverter")
    private AddressConverter addressConverter;

    private AESEncryption aesEncryption = new AESEncryption();

    public Employee modelToEntity(EmployeeModel employeeModel) {
        Employee employee = new Employee();
        try {
            SecretKey secKey = aesEncryption.getSecretEncryptionKey();
            employee.setSecKey(Base64.getEncoder().encodeToString(secKey.getEncoded()));
            employee.setId(employeeModel.getId());
            employee.setFirstName(Base64.getEncoder().encodeToString(aesEncryption.encryptText(employeeModel.getFirstName(), secKey)));
            employee.setLastName(Base64.getEncoder().encodeToString(aesEncryption.encryptText(employeeModel.getLastName(), secKey)));
            employee.setEmail(Base64.getEncoder().encodeToString(aesEncryption.encryptText(employeeModel.getEmail(), secKey)));
            employee.setMobile(Base64.getEncoder().encodeToString(aesEncryption.encryptText(employeeModel.getMobile(), secKey)));
            employee.setAddress(
                    addressConverter.modelToEntity(employeeModel.getAddressModel())
            );
        } catch (Exception e) {
            System.out.println("EmployeeConverter.java(1) exception: " + e.getMessage());
            e.printStackTrace();
        }
        return employee;
    }

    public EmployeeModel entityToModel(Employee employee) {
        EmployeeModel employeeModel = new EmployeeModel();
        try {
            SecretKey secKey = aesEncryption.rebuildSecretEncryptionKey(employee.getSecKey());

            employeeModel.setId(employee.getId());
            employeeModel.setFirstName(aesEncryption.decryptText(Base64.getDecoder().decode(employee.getFirstName()), secKey));
            employeeModel.setLastName(aesEncryption.decryptText(Base64.getDecoder().decode(employee.getLastName()), secKey));
            employeeModel.setEmail(aesEncryption.decryptText(Base64.getDecoder().decode(employee.getEmail()), secKey));
            employeeModel.setMobile(aesEncryption.decryptText(Base64.getDecoder().decode(employee.getMobile()), secKey));
            employeeModel.setAddressModel(
                    addressConverter.entityToModel(employee.getAddress())
            );
        } catch (Exception e) {
            System.out.println("EmployeeConverter.java(2) exception: " + e.getMessage());
            e.printStackTrace();
        }
        return employeeModel;
    }
}
