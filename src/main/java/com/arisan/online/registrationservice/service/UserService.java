package com.arisan.online.registrationservice.service;

import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arisan.online.registrationservice.domain.Users;
import com.arisan.online.registrationservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/** Save **/
	public void insertUser(Users users) {
		userRepository.save(users);
	}

	/** Delete */
	public void deleteUser(Users users) {
		userRepository.delete(users);
	}

	/** List */
	public List<Users> getListUser() {
		return userRepository.findAll();
	}

	/** Selected Element */
	public Users getSelectedUser(Long id) {
		Optional<Users> result = userRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	/** Encrypt **/
	public String hashingPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}
}
