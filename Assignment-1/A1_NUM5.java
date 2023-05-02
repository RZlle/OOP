/*  Write a Java program that accepts two double variables
and test if both strictly between 0 and 1 and false otherwise*/

import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Input first number: ");
        double fNum = myObj.nextDouble();
        System.out.print("Input second number: ");
        double sNum = myObj.nextDouble();

        if ( fNum > 0 && fNum < 1  && sNum > 0 && sNum < 1 )
            System.out.print("True");
        else
            System.out.print("False");
    }
}
