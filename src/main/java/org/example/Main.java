package org.example;

import org.example.exceptions.WrongLoginException;
import org.example.exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        System.out.println(validateRegistration("petr", "12345Password_","12345Password_"));
    }


    public static boolean validateRegistration(String login, String password, String confirmPassword) {
        try {
            registration(login, password, confirmPassword);
            return true;
        } catch (WrongPasswordException | WrongLoginException e) {
            e.printStackTrace();
            return false;
        }
    }

    // boolean onlyLatinAlphabet = string.matches("^[a-zA-Z0-9]+$");
    public static void registration(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        if (login.length() > 20 || login == null) {
            throw new WrongLoginException();
        }
        if (password.length() >= 20 || password == null) {
            throw new WrongPasswordException();
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
        if(!login.matches("^\\w+$")){
            throw new WrongLoginException();
        }
        if(!password.matches("^\\w+$")){
            throw new WrongPasswordException();
        }

    }
}