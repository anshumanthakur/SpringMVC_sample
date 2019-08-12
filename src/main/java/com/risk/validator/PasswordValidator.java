package com.risk.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<IsPasswordValid, String>{

	@Override
	public void initialize(IsPasswordValid is) {
		
		is.message();
		
	}

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
	
		if (password.isEmpty()) {

			return false;
		}
		

		//String MOBILE_PATTERN = "^([a-zA-Z0-9@*#%&]{8,15})$";
		String MOBILE_PATTERN="^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+*!=]).*$";
		Pattern pattern = Pattern.compile(MOBILE_PATTERN);
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			return true;
		} else

			return false;
		
	}

}