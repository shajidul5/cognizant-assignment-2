package com.cognizant.cognizant_assignment_2.Services;

import com.cognizant.cognizant_assignment_2.Models.Address;
import com.cognizant.cognizant_assignment_2.Repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public List<Address> findAllAddresses(){
        return addressRepository.findAll();
    }

    public Address findOneAddress(Long id){
        return addressRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
