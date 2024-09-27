package com.mst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mst.service.auth.AuthService;
import com.mst.service.auth.requests.SignInRequest;
import com.mst.service.auth.requests.SignUpRequest;
import com.mst.service.auth.response.JwtAuthenticationResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	@Autowired
	private AuthService authenticationService;
	
	 @PostMapping("/signup")
	    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
	    	System.out.println(request);
	        return ResponseEntity.ok(authenticationService.signUp(request));
	    }

	    @PostMapping("/signin")
	    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request) {
	        return ResponseEntity.ok(authenticationService.signIn(request));
	    }
	
	    //eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBbWVlbklAZ21haWwuY29tIiwiaWF0IjoxNzI3NDQyNTAyLCJleHAiOjE3Mjc0NDM5NDJ9.zeRx1gK6MeA_dTyYpkjkG_4Ilep50vrTXSypp8eiVEg
	    //eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBbWVlbklAZ21haWwuY29tIiwiaWF0IjoxNzI3NDQzMDQzLCJleHAiOjE3Mjc0NDQ0ODN9.kFHtAZICrp2vnS-mURbthj2W5JMvQiQKkRolA5VFVBQ
}
