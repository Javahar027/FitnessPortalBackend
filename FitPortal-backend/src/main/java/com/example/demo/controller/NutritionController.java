package com.example.demo.controller;

import com.example.demo.entity.Nutrition;
import com.example.demo.entity.User;

import com.example.demo.repo.NutritionRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class NutritionController {

    @Autowired
    NutritionRepo nr;
    @Autowired
    UserRepo ur;

    @CrossOrigin(origins="http://localhost:3000")
    @PostMapping("/nutritionWeightloss/{id}/insert")


    public ResponseEntity<Void> deitOfSpecificUser(@PathVariable int id, @RequestBody Nutrition n){
        Optional<User> o=ur.findById(id);
        if(o.isPresent()) {
            n.setUser_id(id);
            nr.save(n);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
