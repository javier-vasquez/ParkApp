package com.app.parkapp.parkapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MARIO MENDOZA on 07/11/2015.
 */
public class Validar {
    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN ="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";

    public boolean validatePassword(final String password){
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
