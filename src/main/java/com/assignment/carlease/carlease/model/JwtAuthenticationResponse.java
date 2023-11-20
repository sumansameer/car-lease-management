package com.assignment.carlease.carlease.model;

public class JwtAuthenticationResponse {
    private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public JwtAuthenticationResponse(String token) {
		super();
		this.token = token;
	}
    
}
