/** 
 * This is the class "SectorRepository", extended by the interface "JpaRepository". Which will be to represent a computer repository.
 * 
 * @author Tales Mateus de Oliveira Ferreira <talesmateus1999@hotmail.com>
 */
package com.pml.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pml.domain.Sector;
@Repository
public interface SectorRepository extends JpaRepository<Sector, Integer>{
	Optional<Sector> findByName(String patrimonyId);
	List<Sector> findByOrderByName();
	
	
	
}
