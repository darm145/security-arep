package edu.eci.arep.server.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arep.server.Services.Name;

@RestController
@CrossOrigin
public class nameController {

    @Autowired
    
    Name nameService;

    @GetMapping("/hello/{name}") 
    public ResponseEntity<?> getName(@PathVariable String name){
        try {
            System.out.println("llegas aca2");
            return new ResponseEntity<>(nameService.hello(name),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }  
}