import java.util.*;

// ===============================
// Strategy Interface
// ===============================
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// ===============================
// Stack Strategy Implementation
// ===============================
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        String cleaned = preprocess(input);
        Stack<Character> stack = new Stack<>();

        for (char ch : cleaned.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : cleaned.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    private String preprocess(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();
    }
}

// ===============================
// Deque Strategy Implementation
// ===============================
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        String cleaned = preprocess(input);
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : cleaned.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    private String preprocess(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();
    }
}

// ===============================
// Context Class (Strategy Injection)
// ===============================
class PalindromeChecker {

    private PalindromeStrategy strategy;

    // Constructor Injection
    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    // Optional: Change strategy at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.isPalindrome(input);
    }
}

// ===============================
// Main Application Class
// ===============================
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Palindrome Checker App =====");
        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeChecker checker = new PalindromeChecker(strategy);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}