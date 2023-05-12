/* Create a Java method that will multiply two integers without multiplication, division,
bitwise operators, and loops. (Tip: use recursion) */

import java.util.Scanner;

public class recursion {

    // method to execute bitwise multiplication
    static int product(int multiplicand, int multiplier) {
        if (multiplier == 0){
            return 0;
        }else if (multiplier > 0){
            return multiplicand + product(multiplicand, multiplier - 1);
        }else {
            return -multiplicand + product(multiplicand, multiplier + 1);
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter your multiplicand: ");
        int multiplicand = myScanner.nextInt();
        System.out.print("Enter your multiplier: ");
        int multiplier = myScanner.nextInt();

        System.out.println("Product: " + product(multiplicand, multiplier));
    }
}
