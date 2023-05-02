//Write a Java program that takes two numbers as input and displays the product of two numbers

import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Input first number: ");
        int fNum = myObj.nextInt();
        System.out.print("Input second number: ");
        int sNum = myObj.nextInt();

        System.out.println( "Solution: " + fNum + " x " + sNum + " = " + fNum*sNum);
    }
}
