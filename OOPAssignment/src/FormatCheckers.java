import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatCheckers {
    static Scanner stdin = new Scanner(System.in);

    public static boolean checkStringDoesNotContainNumbers(String word){
        char[] chars = word.toCharArray();
        for (char c: chars){
            if (Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    public static String returnStringWhenNoNumbers(){
        boolean validStreetName = false;
        String word = "";
        while (!validStreetName){
            word = stdin.nextLine();
            validStreetName = checkStringDoesNotContainNumbers(word);
            if (!checkStringDoesNotContainNumbers(word)){
                System.out.println("You've entered a number in this word, please try again");
            }
        }
        return word;
    }

    public static String returnCorrectPhoneNumberFormat(){
        boolean valid = false;
        String phoneNumber = "";
        while (valid == false){
            phoneNumber = stdin.nextLine();
            valid = phoneChecker(phoneNumber);
        }
        return phoneNumber;
    }

    public static boolean phoneChecker(String phoneNumber){
        boolean valid = false;
        Pattern pattern = Pattern.compile("^0[0-9]{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches() == true){
            valid =true;
        }else{
            System.out.println("You've inputted an incorrect number format please try again");
        }
        return valid;
    }

    public static String returnCorrectCardNumberFormat(){
        boolean valid = false;
        String cardNumber = "";
        while (valid == false){
            cardNumber = stdin.nextLine();
            valid = cardChecker(cardNumber);
        }
        return cardNumber;
    }

    public static boolean cardChecker(String cardNumber){
        boolean valid = false;
        Pattern pattern = Pattern.compile("^[0-9]{16}$");
        Matcher matcher = pattern.matcher(cardNumber);
        if (matcher.matches() == true){
            valid =true;
        }else{
            System.out.println("You've inputted an incorrect card number format please try again");
        }
        return valid;
    }

    public static String returnCorrectDateFormat(){
        boolean valid = false;
        String date = "";
        while (valid == false){
            date = stdin.nextLine();
            valid = dateChecker(date);
        }
        return date;
    }

    public static boolean dateChecker(String date){
        boolean valid = false;
        Pattern pattern = Pattern.compile("((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(date);
        if (matcher.matches() == true){
            valid =true;
        }else{
            System.out.println("You've inputted an incorrect date format please try again (YYYY-MM-DD)");
        }
        return valid;
    }

    public static String checkCorrectEmail(){
        boolean valid = false;
        String email = "";
        while (valid == false){
            email = stdin.nextLine();
            valid = emailChecker(email);
        }
        return email;
    }

    public static boolean emailChecker(String email){
        boolean valid = false;
        Pattern pattern = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches() == true){
            valid =true;
        }else{
            System.out.println("You've inputted an incorrect email format please try again");
        }
        return valid;
    }

    public static boolean postcodeLength7Checker(String postcode){
        boolean valid = false;
        Pattern pattern = Pattern.compile("^[A-Z]{2}[0-9]{3}[A-Z]{2}$");
        Pattern pattern1 = Pattern.compile("^[A-Z]{2}[0-9]{1}[A-Z]{1}[0-9]{1}[A-Z]{2}$");
        Matcher matcher = pattern.matcher(postcode.toUpperCase());
        Matcher matcher1 = pattern1.matcher(postcode.toUpperCase());
        if (matcher.matches() == true){
            valid = true;
        }else if (matcher1.matches() == true){
            valid = true;
        }else{
            System.out.println("You've inputted an invalid postcode format");
        }
        return valid;
    }

    public static boolean postcodeLength6Checker(String postcode){
        boolean valid = false;
        Pattern pattern = Pattern.compile("^[A-Z]{1}[0-9]{1}[A-Z]{1}[0-9]{1}[A-Z]{2}$");
        Pattern pattern1 = Pattern.compile("^[A-Z]{1}[0-9]{3}[A-Z]{2}$");
        Pattern pattern2 = Pattern.compile("^[A-Z]{2}[0-9]{2}[A-Z]{2}$");
        Matcher matcher = pattern.matcher(postcode.toUpperCase());
        Matcher matcher1 = pattern1.matcher(postcode.toUpperCase());
        Matcher matcher2 = pattern2.matcher(postcode.toUpperCase());
        if (matcher.matches() == true){
            valid = true;
        }else if (matcher1.matches() == true){
            valid = true;
        }else if (matcher2.matches() == true){
            valid = true;
        }else{
            System.out.println("You've inputted an invalid postcode format");
        }
        return valid;
    }

    public static boolean postcodeLength5Checker(String postcode){
        boolean valid = false;
        Pattern pattern = Pattern.compile("^[A-Z]{1}[0-9]{2}[A-Z]{2}$");
        Matcher matcher = pattern.matcher(postcode.toUpperCase());
        if (matcher.matches() == true){
            valid = true;
        }else{
            System.out.println("You've inputted an invalid postcode format");
        }
        return valid;
    }

    public static String returnCorrectPostcodeFormat(){
        boolean valid = false;
        String postCode = "";
        while (valid == false){
            postCode = stdin.nextLine();
            char[] chars = postCode.toCharArray();
            if (chars.length == 7){
                valid =postcodeLength7Checker(postCode);
            }else if (chars.length == 6){
                valid = postcodeLength6Checker(postCode);;
            }else if (chars.length == 5){
                valid = postcodeLength5Checker(postCode);
            }
        }
        return postCode;
    }
}
