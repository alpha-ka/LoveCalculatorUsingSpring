package com.alpha.lc.config;

import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alpha.lc.formatter.PhoneFormatter;

@EnableWebMvc // this will enable all Spring web MVC configurations
@Configuration
@ComponentScan(basePackages = {"com.alpha.lc.controller","com.alpha.lc.service"})
//@ComponentScan
//to access formatter logic we should implement webmvcconfiguration interface
@PropertySource("classpath:email.properties")
public class LoveCalculatorAppJavaConfig implements WebMvcConfigurer {

	// set up my view resolver

	@Autowired
	private Environment env;
	@Value("${spring.mail.host}")
	String host;
	@Value("${spring.mail.username}")
	String userName;
	@Value("${spring.mail.password}")
	String password;
	@Value("${spring.mail.port}")
	int port;
	 
	
	
	Logger logger=Logger.getLogger(LoveCalculatorAppJavaConfig.class.getName());
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		//System.out.println("Inside view resolver bean method");
		logger.info(">>>>>>>Inside view resolver bean method");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
 
	@Bean
	public JavaMailSender getJavaMailSender() {
		
		
		//System.out.println("Java Mail Sender Config");
		logger.info(">>>>>>>Java Mail Sender Config");
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		//Hard coded values
//		javaMailSenderImpl.setHost("smtp.gmail.com");
//		javaMailSenderImpl.setUsername("dhanush.alpha3@gmail.com");
//		javaMailSenderImpl.setPassword("rqwcpeynclvwljma");
//		javaMailSenderImpl.setPort(587);
 
		
		
		//Environment property with property source annotation way of fetching detail
//		javaMailSenderImpl.setHost(env.getProperty("spring.mail.host"));
//		javaMailSenderImpl.setUsername(env.getProperty("spring.mail.username"));
//		javaMailSenderImpl.setPassword(env.getProperty("spring.mail.password"));
//		javaMailSenderImpl.setPort(getIntProperty("spring.mail.port"));
		
		
		//Fetching values from properties file using @Value Annotation
		
		javaMailSenderImpl.setHost(host);
		javaMailSenderImpl.setUsername(userName);
		javaMailSenderImpl.setPassword(password);
		javaMailSenderImpl.setPort(port);
		
		Properties prop = new Properties();
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		javaMailSenderImpl.setJavaMailProperties(prop);
		return javaMailSenderImpl;

	}
	//Helper Method
	int getIntProperty(String key)
	{
		String port=env.getProperty(key);
		return Integer.parseInt(port);
		
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		//System.out.println("Inside formatter bean method");
		logger.info(">>>>>>>Inside formatter bean method");
		registry.addFormatter(new PhoneFormatter());
	}

}
