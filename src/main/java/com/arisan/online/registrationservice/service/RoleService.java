package com.arisan.online.registrationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arisan.online.registrationservice.domain.Role;
import com.arisan.online.registrationservice.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	/**List*/
	public List<Role> getListRole(){
		return roleRepository.findAll();
	}
	
	/**Selected Role **/
	public Role getSelectedRole(Long id) {
		Optional<Role> result = roleRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
			return null;
		}
	}
	
}
