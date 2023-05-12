/* Create a Java method that will convert a floating value to an absolute value. */

import java.util.Scanner;
public class float_to_absolute {

    //method that convert input float number to absolute value
    static float absolute(float number)
    {
        float abso_value = (number >= 0) ? number : -number;
        return abso_value;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a float number: ");
        float number = myScanner.nextFloat();
        System.out.println("Absolute value: " + absolute(number));

    }
}

