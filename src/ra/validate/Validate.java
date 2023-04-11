package ra.validate;

import java.util.Scanner;

public class Validate {
    private static String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static boolean validate(String regex){
        return regex.matches(EMAIL_REGEX);
    }
}
