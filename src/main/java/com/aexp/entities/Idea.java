package com.aexp.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ideaSummary;
    private String ideaDescription;
    private String createdBy;
    private LocalDate createdDate;
    private String updatedBy;
    private LocalDate updatedDate;
    private String ideaStatus;

    public Idea(String ideaSummary, String ideaDescription, String createdBy, LocalDate createdDate, String updatedBy, LocalDate updatedDate, String ideaStatus) {
        this.ideaSummary = ideaSummary;
        this.ideaDescription = ideaDescription;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.ideaStatus = ideaStatus;
    }




}