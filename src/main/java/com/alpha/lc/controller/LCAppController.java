package com.alpha.lc.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alpha.lc.api.UserInfoDTO;
import com.alpha.lc.service.LCAppService;

@Controller
//Session to SessionAttribute and it store as model 
@SessionAttributes("userInfoDTO")//ModelAttribut name also should be same
//@SessionAttributes({"userInfoDTO","",""})//Mutiple Session Attributes
public class LCAppController {
	
	@Autowired
	private LCAppService lcAppService;
	
	Logger logger=Logger.getLogger(LCAppController.class.getName());
	
//	@RequestMapping("/")
//	public String showHomePage()
//	{
//		//Read default values fetch from the UserInfoDTO
//		System.out.println("HomePage method called..");
//		return "home-page";
//		
//	}
	
	///2ways of Binding default values into initial form
	//we are going to achieve this using Spring MVC form tags in html
	///Search on browser spring mvc form tags
	//<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
//	@RequestMapping("/")
//	public String showHomePage(Model model)
//	{
//		//Read default values fetch from the UserInfoDTO
//		System.out.println("Here i'm createing object so not spring");
//		UserInfoDTO userInfoDTO=new  UserInfoDTO();
//		System.out.println("Object created and initializing by user so not spring");
////		model.addAttribute("userName", userInfoDTO.getUserName());
////		model.addAttribute("crushName", userInfoDTO.getCrushName());
//		model.addAttribute("userInfoDTO", userInfoDTO);
//		
//		System.out.println("HomePage method called..");
//		return "home-page-springmvcformtags";
//		
//	}
//	
//	
//	
//	
//	//2 ways of DATA binding from URL parameter to variable
//	//Using @requestparam binding into string variable
//	//Using class DTO
//	
////	@RequestMapping("/process-homepage")
////	//DATA Binding URL parameter value with String variable and if URL parameter String name is different then use ("urlparametername")						
////	public String processHomepage(@RequestParam String userName,@RequestParam("crushName") String cName,Model model)
////	{
////		System.out.println("User Name : "+userName+"\nCrush Name : "+cName);
////		model.addAttribute("userName", userName);
////		model.addAttribute("crushName", cName);
////		
////		return "result-page";
////	}
////	
//
//	@RequestMapping("/process-homepage")	
//	//Data blinding URL parameter value into a class DTO
//	//Spring internally creates object for it and calls the setter method and initializes the value
//	//so we can fetch easily Spring makes work easier
//	public String processHomepage(UserInfoDTO userInfoDTO,Model model)
//	{
//		//Writing value to the string property from the URL Parameter
//		
////		String uName=userInfoDTO.getUserName();
////		String cName=userInfoDTO.getCrushName();
////		
////		System.out.println("User Name : "+uName+"\nCrush Name : "+cName);
////		model.addAttribute("userName", uName);
////		model.addAttribute("crushName", cName);
//		
//		System.out.println("We are trying to fetch the values from UserInfoDTO table so ");
//		model.addAttribute("userInfoDTO", userInfoDTO);	
//		return "result-page";
//	}
 
	
//---------------@ModelAttribute and Cookie feature fetch value using HttpServletRequest and store using HttpServletResponse
	//We are going to change all above coding in one line 
	//using @ModelAttribute
	//we don't need to create object to read values so defining it and then  
	//sending that reference object to model using @ModelAttribute
	//we don't need to create Model object or UserInfoDTO Object

//	@RequestMapping("/")
//	public String showHomePage(@ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO, HttpServletRequest request)
//	{	 
//		Cookie cookies[]=  request.getCookies();
//		for(Cookie cookie:cookies)
//		{
//			if(cookie.getName().equals("lcApp.userName"))
//			  userInfoDTO.setUserName(cookie.getValue());
//		}
//		
//	return "home-page-springmvcformtags";		
//	}
//	
//	//UserInfoDTO defined so spring will the object with passed URL parameter value and then passing it to @ModelAttribute
//	//@Valid will help to do bean validation and then stores the result in bindingResult
//	//Don't change the order of definitions in method argus
//	//to work below code we need hibernate validator maven dependency
//	@RequestMapping("/process-homepage")
//	public String processHomepage(@Valid @ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO, BindingResult result, Model model,HttpServletResponse response)
//	{
//		if(result.hasErrors())
//		{
//			//System.out.println("Form has errors...");
//			 System.out.println(userInfoDTO.isTermsAndConditions());
//			 List<ObjectError> allErrors = result.getAllErrors();
//			 for(ObjectError obj:allErrors)
//			 {
//				 System.out.println(obj);
//			 }
//			
//			return "home-page-springmvcformtags";	
//		}
//		else
//			System.out.println("No Errors...........");
//		
//		model.addAttribute("result","Friends");
//		
//		
//		Cookie cookie=new Cookie("lcApp.userName", userInfoDTO.getUserName());
//		
//		cookie.setMaxAge(60*60*24);
//		System.out.println("\n Cookie Name "+cookie.getName()+" .text file will stay for " +cookie.getMaxAge()+" hours.\n");
//		//but we should add cookies with httpservletresponse
//		// we just define httpservletresponse so spring create object for us so will initialize this
//		response.addCookie(cookie);	
//		
//	return "result-page";		
//	}
//	

// @ModelAttribute and Cookie using Spring way because we can't cookie array object and check each and every handle method
	//to use cookie stored values
//	@RequestMapping("/")
//	public String showHomePage(@CookieValue("lcApp.userName") String userName, @ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO)
//	{	 
//			  userInfoDTO.setUserName(userName);
//
//	return "home-page-springmvcformtags";		
//	}
//	
//	//UserInfoDTO defined so spring will the object with passed URL parameter value and then passing it to @ModelAttribute
//	//@Valid will help to do bean validation and then stores the result in bindingResult
//	//Don't change the order of definitions in method argus
//	//to work below code we need hibernate validator maven dependency
//	@RequestMapping("/process-homepage")
//	public String processHomepage(@Valid @ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO, BindingResult result, Model model,HttpServletResponse response)
//	{
//		if(result.hasErrors())
//		{
//			//System.out.println("Form has errors...");
//			 System.out.println(userInfoDTO.isTermsAndConditions());
//			 List<ObjectError> allErrors = result.getAllErrors();
//			 for(ObjectError obj:allErrors)
//			 {
//				 System.out.println(obj);
//			 }
//			
//			return "home-page-springmvcformtags";	
//		}
//		else
//			System.out.println("No Errors...........");
//		
//		model.addAttribute("result","Friends");
//		
//		
//		Cookie cookie=new Cookie("lcApp.userName", userInfoDTO.getUserName());
//		
//		cookie.setMaxAge(60*60*24);
//		System.out.println("\n Cookie Name "+cookie.getName()+" .text file will stay for " +cookie.getMaxAge()+" hours.\n");
//		//but we should add cookies with httpservletresponse
//		// we just define httpservletresponse so spring create object for us so will initialize this
//		response.addCookie(cookie);	
//		
//	return "result-page";		
//	}
	
// Session- HttpSession/HttpServletRequest
	
	
//	@RequestMapping("/")
//	public String showHomePage( @ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO)
//	{	 
//		 
//
//	return "home-page-springmvcformtags";		
//	}
//	
//	//UserInfoDTO defined so spring will the object with passed URL parameter value and then passing it to @ModelAttribute
//	//@Valid will help to do bean validation and then stores the result in bindingResult
//	//Don't change the order of definitions in method argus
//	//to work below code we need hibernate validator maven dependency
//	@RequestMapping("/process-homepage")
//	public String processHomepage(@Valid @ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO, BindingResult result, Model model,HttpServletRequest req )
//	{
//		if(result.hasErrors())
//		{
//			//System.out.println("Form has errors...");
//			 System.out.println(userInfoDTO.isTermsAndConditions());
//			 List<ObjectError> allErrors = result.getAllErrors();
//			 for(ObjectError obj:allErrors)
//			 {
//				 System.out.println(obj);
//			 }
//			
//			return "home-page-springmvcformtags";	
//		}
//		else
//			System.out.println("No Errors...........");
//		
//		model.addAttribute("result","Friends");
//		
//		//Session setAttribute
//		
//		HttpSession session=req.getSession();//if there is a session give or else create new session
//		System.out.println("Session id:"+ session.getId()+" and Creation time" + session.getCreationTime());
//		
//		session.setAttribute("userName", userInfoDTO.getUserName());
//		session.setAttribute("crushName", userInfoDTO.getCrushName());
//		//we can this userName variable in any page ${userName}
//		
//		//Session stored in server long term storage
//		//How to over come that? here is it		
//		session.setMaxInactiveInterval(120);//seconds
//				
//		System.out.println("Session stores and holds only "+session.getMaxInactiveInterval()+" Seconds");
//		
//		
//		
//	return "result-page";		
//	}
	
//SESSION to @SessionAttributes("") class controller check below @Controller
	
	@RequestMapping("/")
	//Whenever we use @ModelAttribute("userInfoDTO") AND @SessionAttributes("userInfoDTO") so we should use another way of Model
	//Ourself we adding Model Attribute
	//public String showHomePage( @ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO)
	public String showHomePage( UserInfoDTO userInfoDTO,Model model)
	{ 
	model.addAttribute("userInfoDTO",userInfoDTO);
	return "home-page-springmvcformtags";		
	}
	
	//UserInfoDTO defined so spring will the object with passed URL parameter value and then passing it to @ModelAttribute
	//@Valid will help to do bean validation and then stores the result in bindingResult
	//Don't change the order of definitions in method argus
	//to work below code we need hibernate validator maven dependency
	@RequestMapping("/process-homepage")
	public String processHomepage(@Valid @ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO, BindingResult result)//, Model model  )
	
	{
		if(result.hasErrors())
		{
			 List<ObjectError> allErrors = result.getAllErrors();
			 for(ObjectError obj : allErrors)
			 {
				 System.out.println(obj);
			 }
			
			return "home-page-springmvcformtags";	
		}
		else
			System.out.println("No Errors...........");
		
		
		String appResult=lcAppService.calculateLove(userInfoDTO.getUserName(), userInfoDTO.getCrushName());
		
		logger.info(userInfoDTO.getUserName()+"+"+ userInfoDTO.getCrushName()+"="+appResult);

		userInfoDTO.setResult(appResult);
		//model.addAttribute("userInfoDTO",userInfoDTO);
	return "result-page";		
	}
}
