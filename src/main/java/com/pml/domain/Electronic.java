/** 
 * This is the abstract class "Electronic", which it will be able to represent a any electronic * 
 * @author Tales Mateus de Oliveira Ferreira <talesmateus1999@hotmail.com>
 */
package com.pml.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pml.domain.enums.EquipmentType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Electronic implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	protected Date createdDate;
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	protected Date lastModifiedDate;
	protected Integer equipmentType;
	protected String manufacturer = "N/A";
	protected String model = "N/A";
	protected String description = "N/A";
	protected boolean itWorks = true;
	// Equipment composed is not a computer part 
	protected boolean itComposed;

	
	public Electronic() {
	}
	
	public Electronic(Long id, Date createdDate, Date lastModifiedDate, EquipmentType equipmentType, 
			String manufacturer, String model, String description, boolean itWorks, boolean itComposed) {
		this.id = id;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.equipmentType = (equipmentType == null) ? null : equipmentType.getCod();
		
		this.manufacturer = (manufacturer != null) ? manufacturer : "N/A";
		this.model = (model != null) ? model : "N/A";
		this.description = (description != null) ? description : "N/A";
		
		this.itWorks = itWorks;
		this.itComposed = itComposed;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public EquipmentType getEquipmentType() {
		return EquipmentType.toEnum(equipmentType);
	}
	
	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType.getCod();
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isItWorks() {
		return itWorks;
	}

	public void setItWorks(boolean itWorks) {
		this.itWorks = itWorks;
	}

	public boolean isItComposed() {
		return itComposed;
	}

	public void setItComposed(boolean isItComposed) {
		this.itComposed = isItComposed;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Electronic other = (Electronic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Electronic [id=");
		builder.append(id);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", lastModifiedDate=");
		builder.append(lastModifiedDate);
		builder.append(", equipmentType=");
		builder.append(equipmentType);
		builder.append(", manufacturer=");
		builder.append(manufacturer);
		builder.append(", model=");
		builder.append(model);
		builder.append(", description=");
		builder.append(description);
		builder.append(", itWorks=");
		builder.append(itWorks);
		builder.append(", itComposed=");
		builder.append(itComposed);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}