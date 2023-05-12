// Write a Java program that takes a number as an input and prints its multiplication table up to 10

import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = myObj.nextInt();

        System.out.println("THE MULTIPLICATION TABLE FOR " + num +":");
        for(int count = 1; count <= 10; count++){
            System.out.println(num + " x " + count + " = " + num*count);
        }
    }
}
