package com.alpha.lc.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alpha.lc.api.CommunicationDTO;
import com.alpha.lc.api.Phone;
import com.alpha.lc.api.UserRegistrationDTO;

@Controller
public class LCAppRegistrationController {
	
//	@RequestMapping("/register")
//	public String RegistrationPage(Model model)
//	{
//		UserRegistrationDTO userRegistrationDTO =new UserRegistrationDTO();
//		userRegistrationDTO.setName("K A Alpha");
//		
//		model.addAttribute("userRegistrationDTO",userRegistrationDTO);
//	
//		return "user-registration-page";
//	}
	
	@RequestMapping("/register")
	public String RegistrationPage(@ModelAttribute("userRegistrationDTO") UserRegistrationDTO userRegistrationDTO)
	{
		System.out.println("Inside register controller");
		userRegistrationDTO.setUserId("alphaka");
		userRegistrationDTO.setUserName("Alpha K A");		
		String pwd="123456";
		char c[]=pwd.toCharArray();		
		userRegistrationDTO.setPassword(c);
		Phone phone=new Phone();
		phone.setCountryCode("+91");
		phone.setNumber("1234567890");
		
		CommunicationDTO communicationDTO=new CommunicationDTO();
		communicationDTO.setPhone(phone);
		communicationDTO.setEmail("abc@gmail.com");
		userRegistrationDTO.setCommunicationDTO(communicationDTO);
		
		return "user-registration-page";
	}

	//@ResponseBody
	@RequestMapping("/process-registration")
	public String ProcessRegistration(@Valid @ModelAttribute("userRegistrationDTO") UserRegistrationDTO userRegistrationDTO, BindingResult result)
	{
		System.out.println("Inside process registration controller");
	   if(result.hasErrors())
	   {
		   System.out.println("Error occurred");
			return "user-registration-page";
	   }
		return "registration-success";
		
	}
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		System.out.println("Init binder called before handler method");
		//we are setting that a particular property should not bind
		//binder.setDisallowedFields("communicationDTO.email");
		System.out.println("String trim purpose");
		StringTrimmerEditor strtrim=new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, "userId", strtrim);
		//We won't allow user to type white space and cheating validators.
		
		
	}
	
}
