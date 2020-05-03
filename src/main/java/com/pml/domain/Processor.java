package com.pml.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pml.domain.enums.ArchitectureType;
import com.pml.domain.enums.EquipmentType;

@Entity
public class Processor extends Electronic {
	private static final long serialVersionUID = 1L;
	@NotNull
	private String processorName;
	@NotNull
	private Integer architecture;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "processor")
	@JsonIgnore
	private Computer computer;
	
	public Processor() {
		super();
		this.setEquipmentType(EquipmentType.PROCESSOR);	
		this.setItComposed(false);
	}
	
	public Processor(Long id, Date createdDate, Date lastModifiedDate, String manufacturer,
			String model, String description, boolean itWorks, String processorNumber, 
			ArchitectureType architecture, Computer computer) {
		super(id, createdDate, lastModifiedDate, EquipmentType.PROCESSOR, manufacturer, model, description, itWorks, false);
		this.processorName = processorNumber;
		this.architecture = architecture.getCod();
		this.setItComposed(false);
	}
	
	public String getProcessorName() {
		return processorName;
	}
	
	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}
	
	public ArchitectureType getArchitecture() {
		return ArchitectureType.toEnum(architecture);
	}
	
	public void setArchitecture(ArchitectureType architecture) {
		this.architecture = architecture.getCod();
	}
	
	public Computer getComputer() {
		return computer;
	}
	
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	
	
}
