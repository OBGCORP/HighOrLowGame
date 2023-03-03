package obg;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	public static boolean isBalanced() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter brackets to be checked");
		String input = scanner.nextLine();
		Stack<Character> brackets = new Stack<Character>();
		for(int i = 0; i < input.length(); i++) {
			if("{[(".contains(Character.toString(input.charAt(i)))) {
				brackets.add(input.charAt(i));
			}
			else if(brackets.peek() == '{' && input.charAt(i) == '}') {
				brackets.pop();
			}
			else if(brackets.peek() == '[' && input.charAt(i) == ']') {
				brackets.pop();
			}
			else if(brackets.peek() == '(' && input.charAt(i) == ')') {
				brackets.pop();
			}
		}
		return brackets.isEmpty() ? true : false;
	}
	
	public static void main(String[] args) {
		
		System.out.println(isBalanced());

	}

}
