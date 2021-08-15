package business.validationRules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.constants.Messages;
import core.utils.results.Result;

public class UserValidator {
	public static Result checkPassword(String password) {
		if(password.length() < 6) {
			Messages.checkPassword();
			return new Result(false, "Parola en az 6 karakterden oluşmalı");
		}
		return new Result(true);
	}
	
	public static Result checkFirstName(String firstName) {
		if(firstName.length() < 2) {
			Messages.checkName();
			return new Result(false, "İsim 2 karakterden az olamaz");
		}
		return new Result(true);
	}
	
	public static Result checkLastName(String lastName) {
		if(lastName.length() < 2) {
			Messages.checkLastName();;
			return new Result(false, "Soyisim 2 karakterden az olamaz");
		}
		return new Result(true);
	}
	
	public static Result emailRegex(String email) {    
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.find() == false)
		{
			Messages.checkEmailRegex();
			return new Result(false, "Geçerli Email girmediniz");
		}
		else {
			return new Result(true);
		}
		
	}
}
