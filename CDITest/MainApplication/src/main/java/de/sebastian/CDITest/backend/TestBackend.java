package de.sebastian.CDITest.backend;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class TestBackend implements Serializable {
	
	private String user;
	
	public TestBackend() {
		
	}
	
	public void saveUser(String user){
		this.user = user;
	}
	
	public String getUser() {
		return user;
	}

}
