package com.alpha.lc.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.alpha.lc.api.EmailDTO;
import com.alpha.lc.api.UserInfoDTO;
import com.alpha.lc.service.LCAppEmailServiceImpl;

@Controller
public class EmailController {
	
	@Autowired
	private LCAppEmailServiceImpl lcAppEmailServiceImpl;
	
	Logger logger=Logger.getLogger(EmailController.class.getName());
	
	//Fetch Value from URL Path using @PathVariable
//	@RequestMapping("/sendEmail/{userName}")
//	public String sendEmail(@PathVariable("userName") String userName, Model model)
//	{
//		model.addAttribute("emailDTO",new EmailDTO());
//		//model.addAttribute("emailDTO",emailDTO);
//		model.addAttribute("userName",userName.toUpperCase());
//		
//		return "send-email-page";
//	}

//	@RequestMapping("/processEmail")
//	public String processEmail(@Valid @ModelAttribute("emailDTO") EmailDTO emailDTO,BindingResult result)
//	{
//		if(result.hasErrors())
//		{
//			return "send-email-page";
//		}
//		return "email-sent";
//	}

	
	//COOKie
	//Fetch value from Cookie instead of from path and  adding in model
//	@RequestMapping("/sendEmail")
//	public String sendEmail(@CookieValue("lcApp.userName") String userName, Model model)
//	{
//		model.addAttribute("emailDTO",new EmailDTO());
//		//model.addAttribute("emailDTO",emailDTO);
//		model.addAttribute("userName",userName.toUpperCase());
//		
//		return "send-email-page";
//	}
//	
//	@RequestMapping("/processEmail")// Important to give arguments in method to work  
//	public String processEmail(@CookieValue("lcApp.userName") String userName,@Valid  @ModelAttribute("emailDTO") EmailDTO emailDTO,BindingResult result,Model model)
//	{
//	
// 
//		if(result.hasErrors())
//		{
//			model.addAttribute("userName",userName.toUpperCase());
//			return "send-email-page";
//		}
//		model.addAttribute("userName",userName.toUpperCase());
//		 
//		return "email-sent";
//	}

	
	
	//SESSION - HttpSession
	
	
	@RequestMapping("/sendEmail")
	public String sendEmailPage(  Model model,HttpSession session)
	{
		//System.out.println("I'm in send email page");
		//System.out.println("Value getting from session User Name: "+session.getAttribute("userName"));
		//System.out.println("Value getting from session Crush Name: "+session.getAttribute("crushName"));
		logger.info(">>>>>>>>I'm in send email page");
		logger.info(">>>>>>>>>Value getting from session User Name: "+session.getAttribute("userName"));
		logger.info(">>>>>>>>Value getting from session Crush Name: "+session.getAttribute("crushName"));
		
		model.addAttribute("emailDTO",new EmailDTO());
		
		return "send-email-page";
	}
	
	@RequestMapping("/processEmail")// Important to give arguments in method to work  
	public String processEmail(@SessionAttribute("userInfoDTO") UserInfoDTO userInfoDTO, @Valid  @ModelAttribute("emailDTO") EmailDTO emailDTO,BindingResult result )
	{
		//System.out.println("I'm in process email");
		logger.info(">>>>>>>>I'm in process email");
		if(result.hasErrors())
		{
			 List<ObjectError> allErrors = result.getAllErrors();
			 for(ObjectError obj : allErrors)
			 {
				 //System.out.println(obj);
				 logger.info(">>>>>>>>"+obj);
			 }
			
			 
			return "send-email-page";
		}
		else
		{
		//System.out.println("No Errors...........");
		logger.info(">>>>>>>>No Errors...........");
		logger.info(">>>>>>>>Love Calculate Result is fetching from session ="+userInfoDTO.getResult());
		lcAppEmailServiceImpl.sendMail(userInfoDTO.getUserName(), emailDTO.getEmail(),userInfoDTO.getResult());
		return "email-sent";
		}
	}
}
