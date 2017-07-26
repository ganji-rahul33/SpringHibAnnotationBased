/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.demo;

import com.ads.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Rahul
 */
@Component("userFormVal")
public class UserFormValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user =  (User)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "NotEmpty.userForm.userId", "mandatorty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password", "mandatorty");
        if(user != null && user.getUserId().length() < 4) {
            errors.rejectValue("userId", "Field.MinLength", new Object[]{"'User Name'"}, "User Name should be atleast four chars");
        }
        if(user != null && user.getUserId().length() >= 16) {
            errors.rejectValue("userId", "Field.MaxLength", new Object[]{"'User Name'"}, "User Name should not be greater than 16 chars");
        }
    }
    
}
