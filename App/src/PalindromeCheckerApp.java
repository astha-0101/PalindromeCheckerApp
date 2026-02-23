
          import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

            public class PalindromeCheckerApp {

                public static void main(String[] args) {

                    Scanner sc = new Scanner(System.in);

                    // Input string
                    System.out.print("Enter a string: ");
                    String input = sc.nextLine();

                    // Initialize queue and stack
                    Queue<Character> queue = new LinkedList<>();
                    Stack<Character> stack = new Stack<>();

                    // Enqueue and push each character
                    for (int i = 0; i < input.length(); i++) {
                        char ch = input.charAt(i);
                        queue.add(ch);  // enqueue
                        stack.push(ch); // push
                    }

                    boolean isPalindrome = true;

                    // Compare dequeue (queue) vs pop (stack)
                    while (!queue.isEmpty()) {
                        if (!queue.remove().equals(stack.pop())) {
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