package com.aexp.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import com.aexp.entities.Idea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import com.aexp.service.OutlawsService;

@RestController
public class OutlawsController {

    @Autowired
    private OutlawsService service;

    @GetMapping("/test")
    public String getTest() {
        return "================> Service is UP...... <===============";
    }

    //CREATE
    @PostMapping("/ideas")
    public String add(@RequestBody Idea idea) {
        service.save(idea);
        return "Idea added";
    }

    //GET ALL API
    @GetMapping("/ideas")
    public List<Idea> list() {
        return service.listAll();
    }

    //GET BY ID  API
    @GetMapping("/ideas/{id}")
    public ResponseEntity<Idea> get(@PathVariable Long id) {
        try {
            Idea idea = service.get(id);
            return new ResponseEntity<Idea>(idea, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Idea>(HttpStatus.NOT_FOUND);
        }
    }

    //UPDATE OPERATION
    @PutMapping("/ideas/{id}")
    public ResponseEntity<?> update(@RequestBody Idea idea, @PathVariable Long id) {
        try {
            Idea existIdea = service.get(id);
            if (!ObjectUtils.isEmpty(idea.getIdeaSummary())) existIdea.setIdeaSummary(idea.getIdeaSummary());
            if (!ObjectUtils.isEmpty(idea.getIdeaDescription())) existIdea.setIdeaSummary(idea.getIdeaDescription());
            service.save(existIdea);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE API
    @DeleteMapping("/ideas/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Idea deleted";
    }
}