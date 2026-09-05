package org.example.Pojos.Request.RestfulBooker.CreateToken;

public class Auth {
	private String password;
	private String username;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}
