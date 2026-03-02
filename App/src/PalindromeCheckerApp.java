public class PalindromeCheckerApp {

    /**
     * Application entry point for UC11.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        PalindromeService service = new PalindromeService();

        String input = "A man a plan a canal Panama";
        boolean result = service.checkPalindrome(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}

/**
 * Service class that contains palindrome logic.
 * Demonstrates encapsulation and separation of concerns.
 */
class PalindromeService {

    /**
     * Checks whether the input string is a palindrome.
     * Ignores case and non-alphanumeric characters.
     *
     * @param input Input string
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {
        // Normalize: remove non-alphanumeric chars and convert to lowercase
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize pointers
        int start = 0;
        int end = normalized.length() - 1;

        // Compare characters moving inward
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
