package com.kpi.recipes.service;

import com.kpi.recipes.api.exception.UserAlreadyExistException;
import com.kpi.recipes.api.model.LoginBody;
import com.kpi.recipes.api.model.RegistrationBody;
import com.kpi.recipes.model.User;
import com.kpi.recipes.model.dao.UserDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserDAO userDAO;
    private EncryptionService encryptionService;
    private JWTService jwtService;

    public UserService(UserDAO userDAO, EncryptionService encryptionService, JWTService jwtService) {
        this.userDAO = userDAO;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;
    }

    public User registerUser(RegistrationBody registrationBody) throws UserAlreadyExistException {
        if (userDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                && userDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistException();
        }
        User user = new User();
        user.setName(registrationBody.getName());
        user.setSurname(registrationBody.getSurname());
        user.setPatronymic(registrationBody.getPatronymic());
        user.setEmail(registrationBody.getEmail());
        user.setBirthdate(registrationBody.getBirthdate());
        user.setPhone(registrationBody.getPhone());
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        user.setUsername(registrationBody.getUsername());
        user.setGender(registrationBody.getGender());
        user.setRole(registrationBody.getRole());
        user = userDAO.save(user);
        return user;
    }
    public String loginUser(LoginBody loginBody){
        Optional<User> optionalUser =  userDAO.findByUsernameIgnoreCase(loginBody.getUsername());
        if(optionalUser.isPresent()){
            User user   = optionalUser.get();
            if(encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())){
                return jwtService.generateJWT(user);
            }
        }
        return null;
    }
}
