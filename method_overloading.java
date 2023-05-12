/*  Create a Java method that will compute the sum of two integers and two doubles
separately, and after showing the result of the two sums, compute for the product of the
sums - the result must be a double data type.
Requirement: Use method overloading. */

import java.util.Scanner;

public class method_overloading {

    // method for adding 2 input integers
    static int sum (int int1, int int2) {
        return int1 + int2;
    }

    //method for adding 2 input doubles
    static double sum (double double1, double double2) {
        return double1 + double2;
    }

    //method to get the product of the sum of input integers and sum of input doubles
    static double product_sum (int sumInt, double sumDouble) {
        return sumInt * sumDouble;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int int1 = myScanner.nextInt();
        System.out.print("Enter second integer: ");
        int int2 = myScanner.nextInt();
        System.out.print("Enter first double: ");
        double double1 = myScanner.nextDouble();
        System.out.print("Enter first double: ");
        double double2 = myScanner.nextDouble();

        int sumInt = sum(int1, int2);
        double sumDouble = sum(double1, double2);

        System.out.println("Result for sum of integers: " + sumInt);
        System.out.println("Result for sum of doubles: " + sumDouble);
        System.out.println("Result for product of both sums: " +  product_sum(sumInt, sumDouble));
    }
}
