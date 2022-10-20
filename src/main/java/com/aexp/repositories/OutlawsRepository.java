package com.aexp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.aexp.entities.Idea;

public interface OutlawsRepository extends CrudRepository<Idea, Long> {
    public Idea findByIdeaSummaryAndIdeaDescriptionAndCreatedByAndUpdatedBy(String ideaSummary, String ideaDescription, String createdBy, String updatedBy);


}