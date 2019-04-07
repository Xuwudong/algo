package com.xwd.stack;

import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	private java.util.Stack<Integer> number = new java.util.Stack<>();
	private HashMap<String, Integer> mapping = new HashMap<>();

	public Solution() {
		mapping.put("+", 1);
		mapping.put("-", 1);
		mapping.put("(", 2);
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

	public void cal(String oper, int num1, int num2) {
		if (oper.equals("+")) {
			number.push(num2 + num1);
		} else if (oper.equals("-")) {
			number.push(num2 - num1);
		} else {
			System.out.println(oper + " \t" + num1 + " \t" + num2);
			throw new Error("calculate error!!!");
		}
	}


	/**
	 * 计算器
	 * 
	 * @param s
	 * @return
	 */
	public int calculate_8(String s) {
		char[] arrs = s.toCharArray();
		int res = 0, sign = 1, n = arrs.length;
		java.util.Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (arrs[i] >= '0') {
				int num = 0;
				while (i < n && arrs[i] >= '0') {
					num = num * 10 + arrs[i++] - '0';
				}
				res += sign * num;
				i--;
			} else if (arrs[i] == '+') {
				sign = 1;
			} else if (arrs[i] == '-') {
				sign = -1;
			} else if (arrs[i] == '(') {
				st.push(res);
				st.push(sign);
				res = 0;
				sign = 1;
			} else if (arrs[i] == ')') {
				res *= st.pop();
				res += st.pop();
			}
		}
		return res;
	}

	/**
	 * 计算得分
	 * 
	 * @param opts
	 * @return
	 */
	public int calPoints(String[] opts) {
		Stack<Integer> numbers = new Stack<>();
		for (int i = 0; i < opts.length; i++) {
			// 表示本轮获得的得分是前两轮有效 回合得分的总和。
			if (opts[i].equals("+")) {
				int num1 = numbers.pop();
				int num2 = numbers.peek();
				numbers.push(num1);
				numbers.push(num1 + num2);
			}
			// 表示本轮获得的得分是前一轮有效 回合得分的两倍。
			else if (opts[i].equals("D")) {
				int num = numbers.peek();
				numbers.push(num * 2);
			}
			// （一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
			else if (opts[i].equals("C")) {
				numbers.pop();
			} else {
				numbers.push(Integer.valueOf(opts[i]));
			}
		}
		int sum = 0;
		while (!numbers.isEmpty()) {
			sum += numbers.pop();
		}
		return sum;
	}

	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("^-?[0-9]+");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
//        System.out.println(new Solution().calPoints(new String[]{"-21", "-66", "39", "+", "+"}));
//        System.out.println(new Solution().calPoints(new String[]{"-9", "-40", "-35", "D", "73"}));
		System.out.println(new Solution().calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));

        System.out.println(new Solution().calculate_8("(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4)))"));
        System.out.println(new Solution().calculate_8("(9-(0-(8-(2))))"));
        System.out.println(new Solution()
                .calculate_8("1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10"));

//        System.out.println(new Solution().calculate("(3-(5-(8+4)"));
		// System.out.println(new
		// Calculator().calculate("(3-(5-8-(2+(9-(0-(8-2)))-4)-4))"));

	}
}
