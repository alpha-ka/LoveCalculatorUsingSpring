package com.alpha.lc.api;

import javax.validation.constraints.NotBlank;

public class EmailDTO {

	@NotBlank(message = "* Can't be empty")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmailDTO [email=" + email + "]";
	}
	
	
	
}
