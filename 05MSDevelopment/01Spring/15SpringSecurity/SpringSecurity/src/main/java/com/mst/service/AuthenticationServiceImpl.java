package com.mst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mst.bean.*;
import com.mst.controller.JwtAuthenticationResponse;
import com.mst.controller.SignInRequest;
import com.mst.controller.SignUpRequest;
import com.mst.repository.UserRepository;

public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JWTService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override // Registration
	public JwtAuthenticationResponse signUp(SignUpRequest request) {

		var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
				.email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(Role.USER)
				.build();
		userRepository.save(user);
		var jwt = jwtService.generateToken(user);
		return JwtAuthenticationResponse.builder().token(jwt).build();
	}

	@Override // login
	public JwtAuthenticationResponse signIn(SignInRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail() , request.getPassword()));
		User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
		
		String jwt = jwtService.generateToken(user);
		return JwtAuthenticationResponse.builder().token(jwt).build();
	}

}
