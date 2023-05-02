// Write a Java program to convert a string into lowercase

import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Input a String: ");

        String word = myObj.nextLine();
        System.out.println("The original form of the string: " + word);
        System.out.println("The conversion of original word to lowercase: " + word.toLowerCase());
    }
}
