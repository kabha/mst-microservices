package com.mst.service.auth;

import com.mst.service.auth.requests.SignUpRequest;
import com.mst.service.auth.requests.SignInRequest;
import com.mst.service.auth.response.JwtAuthenticationResponse;

public interface AuthService {
	
	JwtAuthenticationResponse signUp (SignUpRequest request);
	JwtAuthenticationResponse signIn(SignInRequest request);
	
}
