package com.alpha.lc.api;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserRegistrationDTO {
	
//@NotBlank(message="* Can't be empty")
@NotEmpty(message="* Can't be empty")//it will allow white space and it says not null
private String userId;
private String userName;
//to binding password into a variable 
//the variable type is better to have char
private char[] password;
private String country;
private String[] hobbies;
private String gender;
private int age;
private CommunicationDTO communicationDTO;




public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public CommunicationDTO getCommunicationDTO() {
	return communicationDTO;
}

public void setCommunicationDTO(CommunicationDTO communicationDTO) {
	this.communicationDTO = communicationDTO;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public char[] getPassword() {
	return password;
}
public void setPassword(char[] password) {
	this.password = password;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String[] getHobbies() {
	return hobbies;
}
public void setHobbies(String[] hobbies) {
	this.hobbies = hobbies;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

@Override
public String toString() {
	return "UserRegistrationDTO [userId=" + userId + ", userName=" + userName + ", password="
			+ Arrays.toString(password) + ", country=" + country + ", hobbies=" + Arrays.toString(hobbies) + ", gender="
			+ gender + ", age=" + age + ", communicationDTO=" + communicationDTO + "]";
}

 
	
}
