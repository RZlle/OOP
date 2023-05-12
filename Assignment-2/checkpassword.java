/* . Create Java method(s) to check whether a string is a valid password and provide the
necessary conditional statement if the terms/rules are not followed (Password is not
valid).
 Password rules:
 A password must have at least ten characters.
 A password consists of only letters and digits.
 A password must contain at least two digits. */

import java.util.Scanner;

public class checkpassword {

    //method to check if the input password length is greater than or equal to ten
    static boolean check_Len(String password) {
        return password.length() >= 10;
    }

    //method to check if the input password has special characters
    static boolean check_LetDig(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //method to check if the input password has at least 2 digits
    static boolean check_2dig(String password) {
        int check = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                check++;
                if (check >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Password Rules:");
        System.out.println("\t1. A password must have at least ten characters.");
        System.out.println("\t2. A password consists of only letters and digits.");
        System.out.println("\t3. A password must contain at least two digits.");
        System.out.print("Input a password: ");
        String password = myScanner.nextLine();


        //statement to check if all the methods are true
        if (check_Len(password) && check_LetDig(password) && check_2dig(password)) {
            System.out.println("Password is Valid: " + password);
        }else {
            System.out.println("Password is Invalid: " + password);
        }
    }
}

