package com.pml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pml.domain.Client;
import com.pml.repositories.ClientRepository;
import com.pml.security.UserSS;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired 
	private ClientRepository userRepository;
	
	// Returns the implementation (UserSS)
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {	
		Optional<Client> optionalClient = userRepository.findByEmail(email);
		if(optionalClient.isEmpty()) 
			throw new UsernameNotFoundException(email);
		Client client = optionalClient.get();
		return new UserSS(client.getId(), client.getEmail(), client.getPassword(), client.getProfiles());
	}
	

}