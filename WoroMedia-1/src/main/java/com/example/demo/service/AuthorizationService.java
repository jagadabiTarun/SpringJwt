package com.example.demo.service;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.database.LoginResponse;
import com.example.demo.database.Roles;
import com.example.demo.database.Users;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.UserRepo;


@Service
@Transactional
public class AuthorizationService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public Users registerUser(String username, String password, String email){

        String encodedPassword = passwordEncoder.encode(password);
        Roles userRole = roleRepository.findByname("USER").get();

        Set<Roles> authorities = new HashSet<>();

        authorities.add(userRole);

        return userRepository.save(new Users((long)0, username, encodedPassword,email, authorities));
    }

    public LoginResponse loginUser(String username, String password){

        try{
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginResponse(userRepository.findByUsername(username).get(), token);

        } catch(AuthenticationException e){
            return new LoginResponse(null, "");
        }
    }

}