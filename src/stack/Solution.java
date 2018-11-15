package stack;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private java.util.Stack<Integer> number = new java.util.Stack<>();
    private java.util.Stack<String> operators = new java.util.Stack<>();
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

    public String handle(String s) {
        // 处理空格
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
        s = sb.toString();
        Pattern p = Pattern.compile("\\(\\s\\d+\\s\\)");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String old = m.group();
            String newStr = old.substring(old.indexOf("(") + 2, old.indexOf(")") - 1);
            s = s.replace(old, newStr);
        }
        return s;
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

    public int calculate(String s) {
        s = handle(s);
        String[] arr = s.trim().split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (isNumericZidai(arr[i])) {
                number.push(Integer.valueOf(arr[i]));
            } else {
                if (operators.isEmpty()) {
                    operators.push(arr[i]);
                } else {
                    String c = operators.peek();
                    // 操作符大于栈顶元素直接push
                    if (mapping.get(arr[i]) > mapping.get(c)) {
                        operators.push(arr[i]);
                    } else {
                        // 栈顶元素或者操作符是“(”，直接push
                        if (c.equals("(") || arr[i].equals("(")) {
                            operators.push(arr[i]);
                            continue;
                        }
                        String oper = operators.pop();
                        // 右括号处理
                        if (oper.equals(")")) {
                            if (!operators.isEmpty() && operators.peek().equals("(")) {
                                operators.pop();
                            }
                            if (!operators.isEmpty()) {
                                oper = operators.pop();
                            }
                            if (operators.size() > 0 && operators.peek().equals("(")) {
                                operators.pop();
                            }
                        }
                        if (number.size() >= 2) {
                            int num1 = number.pop();
                            int num2 = number.pop();
                            cal(oper, num1, num2);
                        }

                        // 递归处理（2+15-4）-4这种情况 为17-4
                        while (operators.size() > 0 && !operators.peek().equals(")") && !operators.peek().equals("(") && number.size() >= 2) {
//                            operators.pop();
//                            if (!operators.isEmpty() && operators.peek().equals("(")) {
//                                operators.pop();
//                            }
//                            if (!operators.isEmpty()) {
//                                oper = operators.pop();
//                            }
//                            if(operators.size() > 0 && operators.peek().equals("(")){
//                                operators.pop();
//                            }
                            oper = operators.pop();
                            if (number.size() >= 2) {
                                int num1 = number.pop();
                                int num2 = number.pop();
                                cal(oper, num1, num2);
                            }
                        }
                        operators.push(arr[i]);
                    }
                }
            }
        }

        //
        while (!operators.isEmpty()) {
            String oper = operators.pop();
            // 右括号处理
            if (oper.equals(")")) {
                if (!operators.isEmpty() && operators.peek().equals("(")) {
                    operators.pop();
                }
                if (!operators.isEmpty()) {
                    oper = operators.pop();
                }
                if (operators.size() > 0 && operators.peek().equals("(")) {
                    operators.pop();
                }
            } else if (oper.equals("(")) {
                continue;
            }
            if (number.size() >= 2) {
                int num1 = number.pop();
                int num2 = number.pop();
                cal(oper, num1, num2);

            }
        }
        if (number.size() != 1 || !operators.isEmpty()) {
            throw new Error("运算错误！");
        }
        return number.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4)))"));
//        System.out.println(new Calculator()
//                .calculate("1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10"));

//        System.out.println(new Solution().calculate("(3-(5-(8+4)"));
        // System.out.println(new
        // Calculator().calculate("(3-(5-8-(2+(9-(0-(8-2)))-4)-4))"));

    }
}
