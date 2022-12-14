package com.aexp.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ideaSummary;
    private String ideaDescription;




}