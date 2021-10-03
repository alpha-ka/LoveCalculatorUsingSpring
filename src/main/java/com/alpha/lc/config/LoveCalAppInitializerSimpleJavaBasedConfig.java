package com.alpha.lc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LoveCalAppInitializerSimpleJavaBasedConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	//Spring creates and initializing DS for us
	//We should pass servlet front controller class or spring config class
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("Spring configuration class as servlet configuration class and it's called by tomcat");
		Class arr[]= {LoveCalculatorAppJavaConfig.class};
		return arr;
	}

	
	//set up URL Mappings
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		System.out.println("URL mapping automatically called by tomcat...");
		//String arr[]= {"/home.com/*","/"};
		String arr[]= {"/"};
		return arr;
	}

}
