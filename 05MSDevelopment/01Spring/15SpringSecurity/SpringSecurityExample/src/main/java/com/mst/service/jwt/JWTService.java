package com.mst.service.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

	String generateToken(UserDetails userdetails);
	String extractUserName(String token);
	boolean isTokenValid(String token, UserDetails userDetails);
}
