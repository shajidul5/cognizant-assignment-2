package com.cognizant.cognizant_assignment_2.Controllers;

import com.cognizant.cognizant_assignment_2.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/address")
@CrossOrigin(origins = "http://localhost:4200")
public class AddressController {

    @Autowired
    private final AddressService addressService;

    @Autowired
    public  AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getAddresses(){
        try{
            ModelMap mm = new ModelMap();
            mm.put("addresses", this.addressService.findAllAddresses());
            return new ResponseEntity<>(mm, HttpStatus.OK);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>("Addresses not found", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAddress(@PathVariable Long id){
        try{
            ModelMap mm = new ModelMap();
            mm.put("addresses", this.addressService.findOneAddress(id));
            return new ResponseEntity<>(mm, HttpStatus.OK);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>("Address not found", HttpStatus.NOT_FOUND);
        }
    }
}
