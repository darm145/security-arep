package edu.eci.arep.server.Services;

import org.springframework.stereotype.Component;

@Component
public class Nameimpl implements Name{

    @Override
    public String hello(String name) {
        
        return "hello "+ name;
    }
    
}