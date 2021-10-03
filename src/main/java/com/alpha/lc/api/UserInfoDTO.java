package com.alpha.lc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {

	//user input name should be same as string variable name
//	private String userName="Mr x";
//	private String crushName="Miss y";
	
	//Server Side validation
	//Bean Validation JSR 349 maven dependency required
	
	@NotBlank(message = "* Your Name can't be blank")
	//@Min(value = 3,message = "* Your Name should have atleast 3 characters")
	@Size(min = 3,max = 20,message = "* Your Name should have char between 3 - 20" )
	private String userName;
	@NotBlank(message = "* Crush Name can't be blank")
	//@Min(value = 3,message = "* Crush Name should have atleast 3 characters")
	@Size(min = 3,max = 20,message = "* Crush Name should have char between 3 - 20" )
	private String crushName;
	
	@AssertTrue(message = "* You have to agree to use our app.")
	private boolean termsAndConditions;
	
	private String result;
	
 
	public boolean isTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(boolean termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	public UserInfoDTO()
	{
		System.out.println("1.UserInfoDTO class consructor automatically called and object created and initialized............... ");
	}
	
	public String getUserName() {
		System.out.println("3.UserInfoDTO class getter method automatically called and returns......... ");
		return userName;
	}
	public void setUserName(String userName) {
		
		System.out.println("2.UserInfoDTO class setter method automatically called and initialized............... ");
		this.userName = userName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [userName=" + userName + ", crushName=" + crushName + ", termsAndConditions="
				+ termsAndConditions + ", result=" + result + "]";
	}


	
	
}
