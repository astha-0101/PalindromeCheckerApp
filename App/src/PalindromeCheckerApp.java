import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    // Approach 1: Reverse String using StringBuilder
    public static boolean checkUsingReverse(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    // Approach 2: Two Pointer Technique
    public static boolean checkUsingTwoPointers(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 3: Using Stack
    public static boolean checkUsingStack(String input) {
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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC13: Palindrome Performance Comparison ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Optional normalization (remove spaces & case-insensitive)
        input = input.replaceAll("\\s+", "").toLowerCase();

        System.out.println("\nRunning Algorithms...\n");

        // --- Reverse Method ---
        long start1 = System.nanoTime();
        boolean result1 = checkUsingReverse(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // --- Two Pointer Method ---
        long start2 = System.nanoTime();
        boolean result2 = checkUsingTwoPointers(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // --- Stack Method ---
        long start3 = System.nanoTime();
        boolean result3 = checkUsingStack(input);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        // Display Results
        System.out.println("===== RESULTS =====");
        System.out.println("Reverse Method      : " + result1 + " | Time: " + time1 + " ns");
        System.out.println("Two Pointer Method  : " + result2 + " | Time: " + time2 + " ns");
        System.out.println("Stack Method        : " + result3 + " | Time: " + time3 + " ns");

        // Determine fastest
        long minTime = Math.min(time1, Math.min(time2, time3));

        System.out.println("\nFastest Algorithm:");
        if (minTime == time1) {
            System.out.println("Reverse Method");
        } else if (minTime == time2) {
            System.out.println("Two Pointer Method");
        } else {
            System.out.println("Stack Method");
        }

        scanner.close();
    }
}