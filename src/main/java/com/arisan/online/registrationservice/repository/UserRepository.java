package com.arisan.online.registrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arisan.online.registrationservice.domain.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>{

	
}
