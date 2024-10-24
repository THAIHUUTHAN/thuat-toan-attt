package nangcao;

import java.util.Stack;

public class InfixToPostfix {
	public static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}// kiểm tra là toán tử hay k

	public static int precedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return -1;
		}
	}// xác định độ ưu tiên toán tử

	public static String infixToPostfix(String infix) {
		StringBuilder postfix = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				postfix.append(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfix.append(stack.pop());
				}
				stack.pop(); // xóa '('
			} else if (isOperator(c)) {
				while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
					postfix.append(stack.pop());
				} // kiểm tra độ ưu tiên toán tử trước khi lấy ra khỏi stack
				stack.push(c);
			}
		}

		while (!stack.isEmpty()) {
			if (stack.peek() == '(') {
				System.out.println("Invalid expression");
				return "";
			}
			postfix.append(stack.pop());
		}

		return postfix.toString();
	}

	public static void main(String[] args) {
		String infix = "5*(7-3)";
		String postfix = infixToPostfix(infix);
		System.out.println("Infix: " + infix);
		System.out.println("Postfix: " + postfix);
	}
}