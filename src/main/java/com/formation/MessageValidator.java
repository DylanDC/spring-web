package com.formation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.formation.model.MessageDto;

public class MessageValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return MessageDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fromUser", "required", "le champ ne doit pas etre vide");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "toUser", "required", "le champ ne doit pas etre vide");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "required", "le champ ne doit pas etre vide");

		MessageDto control = (MessageDto) target;
		if (!(Character.isUpperCase(control.getFromUser().charAt(0)))) {

			errors.rejectValue("fromUser", "requiered", new Object[] { "'user'" },
					"Utilisateur a besoin d'une majuscule");

		}
	}
}
