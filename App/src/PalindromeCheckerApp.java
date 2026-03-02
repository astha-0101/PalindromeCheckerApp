import java.util.Stack;

class PalindromeCheckerApp {

    // Public method exposed to users
    public boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }

        String cleanedInput = preprocess(input);
        return isPalindromeUsingStack(cleanedInput);
    }

    // Encapsulated helper method
    private String preprocess(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();
    }

    // Internal stack-based palindrome logic
    private boolean isPalindromeUsingStack(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}