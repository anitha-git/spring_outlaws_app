package com.aexp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
@Data
public class OutlawsDTO {

	private Long id;
	@JsonProperty("idea_summary")
	private String ideaSummary;
	@JsonProperty("idea_description")
	private String ideaDescription;
	@JsonProperty("created_by") 
    private String createdBy;
	@JsonProperty("updated_by")
	private String updatedBy;
	@JsonProperty("idea_status")
	private String idaStatus;
	@JsonProperty("created_date")
	private LocalDate createdDate;
    @JsonProperty("updated_date")
    private LocalDate updatedDate;
	

}