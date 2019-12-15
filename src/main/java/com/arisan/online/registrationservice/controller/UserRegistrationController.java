package com.arisan.online.registrationservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arisan.online.registrationservice.domain.Role;
import com.arisan.online.registrationservice.domain.Users;
import com.arisan.online.registrationservice.service.RoleService;
import com.arisan.online.registrationservice.service.UserService;
import com.arisan.online.registrationservice.util.ConstantsVariable;

import net.minidev.json.JSONObject;


@RestController
@RequestMapping("/register")
@CrossOrigin
public class UserRegistrationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping
	public ResponseEntity<?> register(@RequestBody Users users) {
		JSONObject response = new JSONObject();
		Role roleMember = roleService.getSelectedRole(ConstantsVariable.CONST_ROLE_MEMBER);
		
		if(users != null) {
			List<Role> roleList = new ArrayList<>();
			roleList.add(roleMember);
			users.setPassword(userService.hashingPassword(users.getPassword()));
			users.setCreatedDate(new Date());
			users.setStatus(ConstantsVariable.CONST_ACTIVE);
			users.setRoles(roleList);
			userService.insertUser(users);
			response.put(ConstantsVariable.CONST_DATA, users);
			response.put(ConstantsVariable.CONST_SUCCESS, true);
			response.put(ConstantsVariable.CONST_ERROR, null);
			response.put(ConstantsVariable.CONST_MESSAGE, "Resgister has been succesed");
		}else {
			response.put(ConstantsVariable.CONST_DATA, null);
			response.put(ConstantsVariable.CONST_SUCCESS, false);
			response.put(ConstantsVariable.CONST_ERROR, "Register Failed");
			response.put(ConstantsVariable.CONST_MESSAGE, "Resgister failed");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
}
