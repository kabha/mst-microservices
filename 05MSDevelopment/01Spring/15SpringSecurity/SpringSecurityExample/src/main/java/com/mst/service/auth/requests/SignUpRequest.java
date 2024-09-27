package com.mst.service.auth.requests;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpRequest {

	private String firstName;
	private String lastName;
	private String email;
	private String password;

}
