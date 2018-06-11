package com.proyecto.seguridad.seguridad.Converters;

import com.proyecto.seguridad.seguridad.Entities.Address;
import com.proyecto.seguridad.seguridad.Models.AddressModel;
import com.proyecto.seguridad.seguridad.Security.AESEncryption;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;

@Component("addressConverter")
public class AddressConverter {

    private AESEncryption aesEncryption = new AESEncryption();

    public Address modelToEntity(AddressModel addressModel){
        Address address = new Address();
        try{
            SecretKey secKey = aesEncryption.getSecretEncryptionKey();
            address.setSecKey(Base64.getEncoder().encodeToString(secKey.getEncoded()));
            address.setId(addressModel.getId());
            address.setStreet(Base64.getEncoder().encodeToString(aesEncryption.encryptText(addressModel.getStreet(), secKey)));
            address.setNumber(Base64.getEncoder().encodeToString(aesEncryption.encryptText(addressModel.getNumber(), secKey)));
            address.setColony(Base64.getEncoder().encodeToString(aesEncryption.encryptText(addressModel.getColony(), secKey)));
            address.setCity(Base64.getEncoder().encodeToString(aesEncryption.encryptText(addressModel.getCity(), secKey)));
            address.setState(Base64.getEncoder().encodeToString(aesEncryption.encryptText(addressModel.getState(), secKey)));
            address.setZip(Base64.getEncoder().encodeToString(aesEncryption.encryptText(addressModel.getZip(), secKey)));
            address.setCountry(Base64.getEncoder().encodeToString(aesEncryption.encryptText(addressModel.getCountry(), secKey)));
        }catch (Exception e){
            System.out.println("AddressConverter.java(1) exception: " + e.getMessage());
            e.printStackTrace();
        }
        return address;
    }

    public AddressModel entityToModel(Address address){
        AddressModel addressModel = new AddressModel();
        try {
            SecretKey secKey = aesEncryption.rebuildSecretEncryptionKey(address.getSecKey());
            addressModel.setId(address.getId());
            addressModel.setStreet(aesEncryption.decryptText(Base64.getDecoder().decode(address.getStreet()), secKey));
            addressModel.setNumber(aesEncryption.decryptText(Base64.getDecoder().decode(address.getNumber()), secKey));
            addressModel.setColony(aesEncryption.decryptText(Base64.getDecoder().decode(address.getColony()), secKey));
            addressModel.setCity(aesEncryption.decryptText(Base64.getDecoder().decode(address.getCity()), secKey));
            addressModel.setState(aesEncryption.decryptText(Base64.getDecoder().decode(address.getState()), secKey));
            addressModel.setZip(aesEncryption.decryptText(Base64.getDecoder().decode(address.getZip()), secKey));
            addressModel.setCountry(aesEncryption.decryptText(Base64.getDecoder().decode(address.getCountry()), secKey));
        }catch (Exception e){
            System.out.println("EmployeeConverter.java(2) exception: " + e.getMessage());
            e.printStackTrace();
        }
        return addressModel;
    }
}
