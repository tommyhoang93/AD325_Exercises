package Recursion;

public class RecursionMethods implements RecursionMethodsInterface {

    // recursive method for factorials
    public static int factorial(int n) {

        // base case
        if (n == 0 || n == 1) {
            return 1;
        } else {

            // recursive call
            return n * factorial(n - 1);
        }
    }

    public static boolean isPalindrome(String word) {

        // ignore capitalization
       word = word.toLowerCase();

       // base case
        if (word.length() <= 1) {
            return true;
        }

        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }
        // recursive call
        return isPalindrome(word.substring(1, word.length() - 1 ));

    }



    }



