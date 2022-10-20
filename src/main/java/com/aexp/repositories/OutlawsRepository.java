package com.aexp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aexp.entities.Idea;

public interface OutlawsRepository extends JpaRepository<Idea, Long> {


}