/* Write a Java program that accepts four integers from the user and
prints equal if all four are equal, and not equal otherwise  */

import java.util.Scanner;
class Main{
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Input first number: ");
        int fNum = myObj.nextInt();
        System.out.print("Input second number: ");
        int sNum = myObj.nextInt();
        System.out.print("Input third number: ");
        int tNum = myObj.nextInt();
        System.out.print("Input fourth number: ");
        int frtNum = myObj.nextInt();

        if (fNum == sNum && sNum == tNum && tNum == frtNum){
            System.out.print("Equal");
        } else {
            System.out.print("Not equal");
        }
    }
}
