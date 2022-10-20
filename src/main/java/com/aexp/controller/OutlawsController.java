package com.aexp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aexp.dto.OutlawsDTO;
import com.aexp.service.OutlawsService;

@RestController
public class OutlawsController {

    @Autowired
    private OutlawsService outlawsService;

    @GetMapping("/test")
    public String getTest() {
        return "================> Service is UP...... <===============";
    }
    
    // CREATE
    @PostMapping(path = "/todos", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String addIdea(@RequestBody OutlawsDTO outlawsDTO) {
    	outlawsService.save(outlawsDTO.getIdeaSummary(), outlawsDTO.getIdeaDescription(),"testuser", "testpwd");
        return "Task added succesfully";
    }

    // READ
    @GetMapping(path = "/todos/{todoId}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public OutlawsDTO getIdea(@PathVariable(value = "todoId") Long todoId) {
        return outlawsService.findById(todoId);
    }
    
    // READ
    @GetMapping(path = "/todos", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<OutlawsDTO> getAllIdeas() {
        return outlawsService.findAll();
    }
    
    // UPDATE
    @PutMapping(path = "/todos/{todoId}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public OutlawsDTO updateIdea(@PathVariable(value = "todoId") Long todoId, @RequestBody OutlawsDTO outlawsDTO) {
        outlawsDTO.setId(todoId);
        return outlawsService.save(outlawsDTO);
    }

    // DELETE
    @DeleteMapping(path = "/todos/{todoId}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String deleteIdea(@PathVariable(value = "todoId") Long todoId) {
        if (todoId != null) {
        	outlawsService.deleteById(todoId);
        }
        return "Task deleted succesfully";
    }


}