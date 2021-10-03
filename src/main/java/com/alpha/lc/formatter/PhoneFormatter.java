package com.alpha.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.alpha.lc.api.Phone;

public class PhoneFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale locale) {
		// TODO Auto-generated method stub
		System.out.println("Inside of phone print method...");
		System.out.println(phone.getCountryCode()+"-"+phone.getNumber());
		return phone.getCountryCode()+"-"+phone.getNumber();
	}

	@Override
	public Phone parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		
		System.out.println("Inside of phone parse method...");

		String str[]=text.split("-");
		Phone phone=new Phone();
		//if phone field doesn't have '-' then we should fix
		int index= text.indexOf("-");
		if(index==-1 || str[0].isEmpty() || text.startsWith("-"))
		{ 
			phone.setCountryCode("+91");
			
			if(str[0].isEmpty() || text.startsWith("-"))
				phone.setNumber(str[1]);
			else
				phone.setNumber(str[0]);
 
			    	
		}
		else
		{
		phone.setCountryCode(str[0]);		
		phone.setNumber(str[1]);
		
		}
		return phone;
	}

}
