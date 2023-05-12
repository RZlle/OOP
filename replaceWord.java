/* Create a Java method that will "count the number of words" in the provided string and
will "ask for an input from the user" for a "word to replace" in the given string and "print the
result in uppercase". */

import java.util.Scanner;

public class replaceWord {

        //method for replacing word in the input sentence
        static String newSentence(String sentence, String replace, String replacement) {
            return sentence.replace(replace, replacement);
        }

        //method for counting the words in the input sentence
        static int num_String(String replacedSentence) {
            return replacedSentence.split("\\s").length;
        }


        public static void main(String[] args) {

            Scanner myScanner = new Scanner(System.in);
            System.out.print(" Enter your sentence: ");
            String sentence = myScanner.nextLine();
            System.out.print(" What is the word you want to replace? ");
            String replace = myScanner.nextLine();
            System.out.print(" What word do you want for replacement? ");
            String replacement= myScanner.nextLine();

            String replacedSentence = newSentence(sentence, replace, replacement);

            System.out.println("Result:");
            System.out.println("Number of words in the string " + num_String(replacedSentence));
            System.out.println("Revise sentence: " + replacedSentence.toUpperCase());
        }
}

