/** 
 * This is the class "UserDTO". That class will be to represent a computer user dto.
 * 
 * @author Tales Mateus de Oliveira Ferreira <talesmateus1999@hotmail.com>
 */
package com.pml.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pml.domain.Client;

public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String email;
	@JsonIgnore
	private String password;
	
	public ClientDTO() {		
	}
	
	public ClientDTO(Client user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}
	
	public ClientDTO(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
		ClientDTO other = (ClientDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}