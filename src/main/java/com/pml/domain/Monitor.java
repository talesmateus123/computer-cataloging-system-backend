/** 
 * This is the class "Monitor", extended by the abstract class "Machine". Which will be to represent a monitor.
 * 
 * @author Tales Mateus de Oliveira Ferreira <talesmateus1999@hotmail.com>
 */
package com.pml.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pml.domain.enums.MachineType;

@Entity
public class Monitor extends Machine{
	private static final long serialVersionUID = 1L;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "monitor")
	@JsonBackReference
	private Computer computer;

	public Monitor() {
		super();
		this.setMachineType(MachineType.MONITOR);
	}

	public Monitor(@Size(max = 10) String patrimonyId, Date createdDate, Date modifiedDate, @Size(max = 100) String manufacturer, 
			@NotEmpty @Size(max = 100) String model, String description, Integer location, Computer computer) {
		super(patrimonyId, createdDate, modifiedDate, MachineType.MONITOR, manufacturer, model, description, location);
		this.computer = computer;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	

	
}