package stack;

import java.util.HashMap;

public class Calculator {
	private java.util.Stack<Integer> number = new java.util.Stack<>();
	private java.util.Stack<String> operators = new java.util.Stack<>();
	private HashMap<String, Integer> mapping = new HashMap<>();

	public Calculator() {
		mapping.put("+", 1);
		mapping.put("-", 1);
		mapping.put("(", 1);
		mapping.put(")", 3);
	}

	public static boolean isNumericZidai(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public int calculator(String s) {
		StringBuilder sb = new StringBuilder(s.trim());
		for (int i = 0; i < sb.length() - 1; i++) {
			if ((sb.charAt(i) >= '0' && sb.charAt(i) <= '9' && sb.charAt(i + 1) != ' '
					&& (sb.charAt(i + 1) < '0' || sb.charAt(i + 1) > '9'))
					|| ((sb.charAt(i) < '0' || sb.charAt(i) > '9') && sb.charAt(i) != ' '
							&& ((sb.charAt(i + 1) >= '0' && sb.charAt(i + 1) <= '9')
									|| ((sb.charAt(i + 1) < '0' || sb.charAt(i + 1) > '9')
											&& sb.charAt(i + 1) != ' ')))) {
				sb = sb.insert(++i, ' ');
			} else if (sb.charAt(i) == ' ' && sb.charAt(i + 1) == ' ') {
				sb.deleteCharAt(i);
			}
		}
		String[] arr = sb.toString().trim().split(" ");
		for (int i = 0; i < arr.length; i++) {
			if (isNumericZidai(arr[i])) {
				number.push(Integer.valueOf(arr[i]));
			} else {
				if (operators.isEmpty()) {
					operators.push(arr[i]);
				} else {
					String c = operators.peek();
					if (mapping.get(arr[i]) > mapping.get(c)) {
						operators.push(arr[i]);
					} else {
						if (operators.peek().equals("(") || arr[i].equals("(")) {
							operators.push(arr[i]);
							continue;
						}
						String oper = operators.pop();
						if (oper.equals(")")) {
							// 右括号处理
							if (!operators.isEmpty() && operators.peek() == "(") {
								operators.pop();
							}
							if (!operators.isEmpty() && number.size() >= 2) {
								oper = operators.pop();
								int num1 = number.pop();
								int num2 = number.pop();
								if (oper.equals("+")) {
									number.push(num2 + num1);
								} else if (oper.equals("-")) {
									number.push(num2 - num1);
								}
								// 丢出小括号
								if (!operators.isEmpty() && operators.peek() == "(") {
									operators.pop();
									if (!operators.isEmpty()) {
										oper = operators.pop();
										num1 = number.pop();
										num2 = number.pop();
										if (oper.equals("+")) {
											number.push(num2 + num1);
										} else if (oper.equals("-")) {
											number.push(num2 - num1);
										}
									}
								}
							}
						} else {
							if (number.size() > 2) {
								int num1 = number.pop();
								int num2 = number.pop();
								if (oper.equals("+")) {
									number.push(num2 + num1);
								} else if (oper.equals("-")) {
									number.push(num2 - num1);
								}
							}
						}
						operators.push(arr[i]);
					}
				}

			}
		}
		while (!operators.isEmpty()) {
			String oper = operators.pop();
			if (oper.equals(")")) {
				if (!operators.isEmpty() && operators.peek().equals("(")) {
					operators.pop();
				}
				// 右括号处理
				if (!operators.isEmpty() && number.size() >= 2) {
					oper = operators.pop();
					int num1 = !number.isEmpty() ? number.pop() : 0;
					int num2 = !number.isEmpty() ? number.pop() : 0;
					if (oper.equals("+")) {
						number.push(num2 + num1);
					} else if (oper.equals("-")) {
						number.push(num2 - num1);
					}
					// 丢出小括号
					if (!operators.isEmpty() && operators.peek() == "(") {
						operators.pop();
						if (!operators.isEmpty() && number.size() >= 2) {
							oper = operators.pop();
							num1 = !number.isEmpty() ? number.pop() : 0;
							num2 = !number.isEmpty() ? number.pop() : 0;
							if (oper.equals("+")) {
								number.push(num2 + num1);
							} else if (oper.equals("-")) {
								number.push(num2 - num1);
							}
						}
					}
				}
			} else if (oper.equals("(")) {
				continue;
			} else {
				if (number.size() >= 2) {
					int num1 = !number.isEmpty() ? number.pop() : 0;
					int num2 = !number.isEmpty() ? number.pop() : 0;
					if (oper.equals("+")) {
						number.push(num2 + num1);
					} else if (oper.equals("-")) {
						number.push(num2 - num1);
					}
				}
			}
		}
		return number.peek();
	}

	public static void main(String[] args) {
		System.out.println(new Calculator().calculator("(3-(2-(5-(9-(4)))))"));
	}
}
