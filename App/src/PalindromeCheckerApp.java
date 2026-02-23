

           import java.util.Scanner;
import java.util.Stack;

        public class PalindromeCheckerApp {

            public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);

                // Input from user
                System.out.print("Enter a string: ");
                String original = sc.nextLine();

                Stack<Character> stack = new Stack<>();

                // Push each character into the stack
                for (int i = 0; i < original.length(); i++) {
                    stack.push(original.charAt(i));
                }

                boolean isPalindrome = true;

                // Pop characters and compare with original
                for (int i = 0; i < original.length(); i++) {
                    if (original.charAt(i) != stack.pop()) {
                        isPalindrome = false;
                        break;
                    }
                }

                // Display result
                if (isPalindrome) {
                    System.out.println("The given string is a Palindrome.");
                } else {
                    System.out.println("The given string is NOT a Palindrome.");
                }

                sc.close();
            }
        }