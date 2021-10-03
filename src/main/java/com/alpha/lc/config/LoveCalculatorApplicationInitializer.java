package com.alpha.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


//First Approach of SPRING WEB MVC JAVA BASED CONFIG just to know how it works
///these thing will done Spring itself so we can achieve Java based config in simple way

// this class because of implementing webapplicationinitializer tomcat finds and calling the onstartup method.
public class LoveCalculatorApplicationInitializer //implements WebApplicationInitializer 
{

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("My custom class which implements WebApplicationInitializer"
				+ "\n Automatically picksup by tomcat and onstartup method called immediately.....");
		
		
		/*//XML servlet configuration
		 * XmlWebApplicationContext webappcontext=new XmlWebApplicationContext(); //set
		 * spring bean configuration file it means front controller servlet xml file
		 * //front-controller-servlet.xml
		 * webappcontext.setConfigLocation("classpath:application-config.xml");
		 */
		
		AnnotationConfigWebApplicationContext webappcontext=new AnnotationConfigWebApplicationContext();
		webappcontext.register(LoveCalculatorAppJavaConfig.class);
		
		//create dispatcher servlet object
		DispatcherServlet dservlet= new DispatcherServlet(webappcontext);
		
		//Register dispatcher servlet with servlet context
		//front controller configuration same like xml file, (servlet name,servlet class)
		/*
		 * ServletRegistration.Dynamic addServlet(java.lang.String servletName, java.lang.String className)
		 */
		ServletRegistration.Dynamic myCustomDispatcherServlet =	servletContext.addServlet("Front-controller", dservlet);
	
		//load on start up
	
		myCustomDispatcherServlet.setLoadOnStartup(1);
		
		///set url mapping
		myCustomDispatcherServlet.addMapping("/home.com/*");
	
	
	}

}
