
   import java.util.Scanner;

    public class PalindromeCheckerApp {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Input from user
            System.out.print("Enter a string: ");
            String original = sc.nextLine();

            // Convert string to character array
            char[] charArray = original.toCharArray();

            boolean isPalindrome = true; // assume it is palindrome

            // Compare characters from start and end
            for (int i = 0; i < charArray.length / 2; i++) {
                if (charArray[i] != charArray[charArray.length - 1 - i]) {
                    isPalindrome = false;
                    break; // exit loop if mismatch
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