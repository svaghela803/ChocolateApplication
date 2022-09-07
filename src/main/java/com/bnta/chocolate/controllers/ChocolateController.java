package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateRepository chocolateRepository;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolate() {
        List<Chocolate> chocolates = chocolateRepository.getAllChocolates();
        return new ResponseEntity<>(chocolates, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Chocolate>> getChocolate(@PathVariable Long id){
        return new ResponseEntity(chocolateRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Chocolate> postChocolate(@RequestBody Chocolate chocolate){
        chocolateRepository.save(chocolate);
        return new ResponseEntity<>(chocolate, HttpStatus.CREATED);
    }

}
