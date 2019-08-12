package com.risk.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<IsPhoneNumberValid, String> {

	@Override
	public void initialize(IsPhoneNumberValid is) {
		is.message();

	}

	@Override
	public boolean isValid(String phone, ConstraintValidatorContext context) {

		if (phone.isEmpty()) {

			return false;
		}

		//String MOBILE_PATTERN = "^[789]{10}$";
		
		String MOBILE_PATTERN = "^([6789]{1})([0123456789]{1})([0-9]{8})$";
		Pattern pattern = Pattern.compile(MOBILE_PATTERN);
		Matcher matcher = pattern.matcher(phone);
		if (matcher.matches()) {
			return true;
		} else

			return false;

	}

}