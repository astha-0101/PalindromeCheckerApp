import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {
        // Normalize string: remove non-alphanumeric chars and convert to lowercase
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("It is a palindrome (ignoring case, spaces, and symbols).");
        } else {
            System.out.println("It is NOT a palindrome.");
        }

        scanner.close();
    }
}
