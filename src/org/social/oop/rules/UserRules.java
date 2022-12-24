package org.social.oop.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.social.oop.exception.EmailFieldNotFilledException;
import org.social.oop.exception.EmailNotValidException;
import org.social.oop.exception.NameFieldNotFilledException;
import org.social.oop.exception.PasswordConfirmationNotMatchException;
import org.social.oop.exception.PasswordFieldNotFilledException;
import org.social.oop.exception.PasswordInvalidException;
import org.social.oop.exception.PhoneFieldNotFilledException;
import org.social.oop.model.User;

public class UserRules {
	
	private Pattern patternEmail = Pattern.compile("^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
	private Pattern patternPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
	
	
	public void fieldUser(User user) throws NameFieldNotFilledException, EmailFieldNotFilledException, PhoneFieldNotFilledException, PasswordFieldNotFilledException, PasswordConfirmationNotMatchException, EmailNotValidException, PasswordInvalidException {
		
		Matcher matcherEmail = patternEmail.matcher(user.getEmail());
		Matcher matcherPassword = patternPassword.matcher(user.getPassword());
		
		if (user.getName() == null || user.getName().equalsIgnoreCase("") || user.getName().equalsIgnoreCase("\n")) 
			throw new NameFieldNotFilledException("Name is required");
		else if (user.getEmail() == null || user.getEmail().equalsIgnoreCase("") || user.getEmail().equalsIgnoreCase("\n"))
			throw new EmailFieldNotFilledException("Email is required");
		else if (user.getPhone() == null || user.getPhone().equalsIgnoreCase("") || user.getPhone().equalsIgnoreCase("\n"))
			throw new PhoneFieldNotFilledException("Phone is required");
		else if (user.getPassword() == null || user.getPassword().equalsIgnoreCase("") || user.getPassword().equalsIgnoreCase("\n"))
			throw new PasswordFieldNotFilledException("Password is required");
		else if (! user.getConfirmPassword().equals(user.getPassword()) && ! user.getConfirmPassword().equals(null))
			throw new PasswordConfirmationNotMatchException("Password and confirm password do not match");
		else if (! matcherEmail.matches())
			throw new EmailNotValidException("Email format invalid. Example valid: user@domain.com");
		else if (! matcherPassword.matches())
			throw new PasswordInvalidException("Invalid password");
	}
}
