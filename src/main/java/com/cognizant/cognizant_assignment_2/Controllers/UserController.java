package com.cognizant.cognizant_assignment_2.Controllers;

import com.cognizant.cognizant_assignment_2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getUsers(){
        try{
            ModelMap mm = new ModelMap();
            mm.put("users", this.userService.findAllUsers());
            return new ResponseEntity<>(mm, HttpStatus.OK);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>("Users not found", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        try{
            ModelMap mm = new ModelMap();
            mm.put("user", this.userService.findOneUser(id));
            return new ResponseEntity<>(mm, HttpStatus.OK);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
