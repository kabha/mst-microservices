package com.mst.service;

import com.mst.controller.JwtAuthenticationResponse;
import com.mst.controller.SignInRequest;
import com.mst.controller.SignUpRequest;

public interface AuthenticationService {

	JwtAuthenticationResponse signUp (SignUpRequest request); 
	JwtAuthenticationResponse signIn (SignInRequest request); 
}
