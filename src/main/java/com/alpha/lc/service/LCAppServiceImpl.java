package com.alpha.lc.service;

import java.util.Iterator;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class LCAppServiceImpl implements LCAppService {

	Logger logger=Logger.getLogger(LCAppServiceImpl.class.getName());
	@Override
	public String calculateLove(String userName, String crushName) {
 
		final String LC_APP_FORMULA="FLAMES";
		int formulaCount=LC_APP_FORMULA.length();
		
		for(int i=0;i<userName.length();i++)
		{
			for(int j=0;j<crushName.length();j++)
			{
				if (userName.toLowerCase().charAt(i)==crushName.toLowerCase().charAt(j))
				{
					userName=userName.substring(0, i)+userName.substring(i+1, userName.length());
					crushName=crushName.substring(0, j)+crushName.substring(j+1, crushName.length());
					logger.info(">>>>>>>>>>>>"+userName+" "+crushName);
					i=0;
					break;
				}
			}
			
		}
		
		int totalCharCount=(userName+crushName).length();
		
		logger.info("Final Concated Name : "+userName+crushName+" - Total Char Count : " + totalCharCount +"; "+LC_APP_FORMULA+" - Formula Count : "+formulaCount);
		
		
		
		
		
		
		//StringBuffer temp=new StringBuffer(LC_APP_FORMULA);
		String temp=LC_APP_FORMULA;
		logger.info(">>>>>>>>>"+temp);
		int k=0;
		int n=temp.length();
		
		while(n>1)
		{
			
			k= totalCharCount%n;
			if(k==0)
				k=n-1;
			else
				k=k-1;
			
			logger.info(">>>>>>>>> Delete char at "+k);
			//temp.deleteCharAt(k);//stringbuffer method
			//temp=temp.substring(0, k)+temp.substring(k+1, temp.length());//String class method
			temp=temp.substring(k+1, temp.length())+temp.substring(0, k);
			 n=temp.length();
	     	logger.info(">>>>>>>>>"+temp+" and it's length is "+n);
	 
			
		}
		logger.info("Result : "+temp);
 
		//char calculateResult=temp.charAt(0);
		char calculateResult=temp.charAt(n-1);
		
		String result=whatsBetweenUS(calculateResult);
		
		
		return result;
	}

	@Override
	public String whatsBetweenUS(char calculateResult) {
	 
		  String result=null;
		switch(calculateResult)
		{
		case 'F':
			result=LCAppConstant.F_CHAR_MEANING;
			break;
		case 'L':
			result=LCAppConstant.L_CHAR_MEANING;
			break;
		case 'A':
			result=LCAppConstant.A_CHAR_MEANING;
			break;
		case 'M':
			result=LCAppConstant.M_CHAR_MEANING;
			break;
		case 'E':
			result=LCAppConstant.E_CHAR_MEANING;
			break;
		case 'S':
			result=LCAppConstant.S_CHAR_MEANING;
			break;
		
		}
		
	return result;
	}

}
