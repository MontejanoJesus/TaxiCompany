package com.solvd.project.taxicompany;

import com.solvd.project.exceptions.EmailException;
import com.solvd.project.exceptions.PhoneNumException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Profile extends Account{
    private static final Logger logger = LogManager.getLogger(Profile.class);
    private String email;
    private String phoneNumber;
    private String bio;

    public Profile() {}
    public Profile(String username, String password, String email, String phoneNumber, String bio){
        super(username, password);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try {
            if (emailValidator(email)) {
                this.email = email;
            }
        } catch (EmailException ee){
            logger.error("Not valid email!");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        try {
            if(phoneNumberValidator(phoneNumber)) {
                this.phoneNumber = phoneNumber;
            }
        } catch (PhoneNumException pne) {
            logger.error("Invalid phone-number format");
        }
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    private Boolean emailValidator(String email) throws EmailException{

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) {
            throw new EmailException();
        }
        return true;
    }
    private Boolean phoneNumberValidator(String phoneNumber) throws PhoneNumException {
        if(phoneNumber.length() != 10) {
            throw new PhoneNumException();
        }
        return true;
    }
}
