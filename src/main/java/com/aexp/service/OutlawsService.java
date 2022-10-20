package com.aexp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aexp.dto.OutlawsDTO;
import com.aexp.entities.Idea;
import com.aexp.repositories.OutlawsRepository;
import com.aexp.utils.ObjectMapperUtils;

@Service
public class OutlawsService {

	@Autowired
	private OutlawsRepository outlawsRepository;

	// Create
	public OutlawsDTO save(String ideaSummary, String ideaDescription, String createdBy, String updatedBy) {
		Idea idea = outlawsRepository.save(new Idea(ideaSummary, ideaDescription, createdBy, LocalDate.now(), updatedBy, LocalDate.now(), "TODO"));
		return (idea == null ? null : ObjectMapperUtils.map(idea, OutlawsDTO.class));
	}

	public OutlawsDTO findById(Long Id) {
		Idea idea = outlawsRepository.findById(Id).get();
		return (idea == null ? null : ObjectMapperUtils.map(idea, OutlawsDTO.class));
	}

	public List<OutlawsDTO> findAll() {
		final List<Idea> ideas = new ArrayList<>();
		outlawsRepository.findAll().forEach(idea -> ideas.add(idea));
		return ObjectMapperUtils.mapAll(ideas, OutlawsDTO.class);
	}

	public OutlawsDTO save(OutlawsDTO outlawsDTO) {
		Optional<Idea> optIdea = outlawsRepository.findById(outlawsDTO.getId());
		Idea idea = optIdea.get();
		if (idea != null) {
			idea.setIdeaSummary(outlawsDTO.getIdeaSummary());
			idea.setIdeaDescription(outlawsDTO.getIdeaDescription());
			idea.setIdeaStatus(outlawsDTO.getIdaStatus());

			idea = outlawsRepository.save(idea);
		}
		return (idea == null ? null : ObjectMapperUtils.map(idea, OutlawsDTO.class));
	}

	public void delete(OutlawsDTO outlawsDTO) {
		outlawsRepository.deleteById(outlawsDTO.getId());
	}

	public void deleteById(Long Id) {
		outlawsRepository.deleteById(Id);
	}
	
	
	
    public OutlawsDTO findByIdeaSummaryAndIdeaDescriptionAndCreatedByAndUpdatedBy(String taskSummary, String taskDescription, String createdBy, String updatedBy){
        Idea idea = outlawsRepository.findByIdeaSummaryAndIdeaDescriptionAndCreatedByAndUpdatedBy(taskSummary, taskDescription, createdBy, updatedBy);
        return (idea == null ? null : ObjectMapperUtils.map(idea, OutlawsDTO.class));
    }
}