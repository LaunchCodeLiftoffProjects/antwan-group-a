package org.launchcode.StLouisAttractions.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.launchcode.StLouisAttractions.model.User;
import org.launchcode.StLouisAttractions.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}
