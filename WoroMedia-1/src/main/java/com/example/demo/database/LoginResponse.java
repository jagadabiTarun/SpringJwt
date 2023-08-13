package com.example.demo.database;

public class LoginResponse {
    private Users user;
    private String jwt;
   
	public LoginResponse(Users user, String jwt) {
		super();
		this.user = user;
		this.jwt = jwt;
		
	}
	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	

}