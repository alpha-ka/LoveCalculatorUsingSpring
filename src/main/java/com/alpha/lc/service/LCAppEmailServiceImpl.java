package com.alpha.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImpl implements LCAppEmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendMail(String userName, String email, String result) {
		// TODO Auto-generated method stub

		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Love Calculator Application Result");
		mail.setText("Hi "+userName+",\n"
				+"\t\tThe Result predicted by the LCApp is " +result
				);
		
		javaMailSender.send(mail);
				
	}

}
