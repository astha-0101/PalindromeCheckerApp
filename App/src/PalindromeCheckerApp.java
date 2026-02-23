
              import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

                public class PalindromeCheckerApp {

                    public static void main(String[] args) {

                        Scanner sc = new Scanner(System.in);

                        // Input string
                        System.out.print("Enter a string: ");
                        String input = sc.nextLine();

                        // Initialize deque
                        Deque<Character> deque = new LinkedList<>();

                        // Insert characters into deque
                        for (int i = 0; i < input.length(); i++) {
                            deque.addLast(input.charAt(i));
                        }

                        boolean isPalindrome = true;

                        // Compare front and rear characters until deque is empty or mismatch
                        while (deque.size() > 1) {
                            if (!deque.removeFirst().equals(deque.removeLast())) {
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