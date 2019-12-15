package com.arisan.online.registrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arisan.online.registrationservice.domain.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{

	
}
