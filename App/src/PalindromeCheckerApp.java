public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {

        // Remove spaces and convert to lowercase
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        // Reverse the string
        String reversed = new StringBuilder(cleaned).reverse().toString();

        // Compare original and reversed
        return cleaned.equals(reversed);
    }
}