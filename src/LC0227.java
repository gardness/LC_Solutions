import com.sun.source.doctree.SummaryTree;

import java.util.HashMap;
import java.util.Stack;

public class LC0227 {

    private HashMap<Character, Integer> map = new HashMap() {{
        put('-', 0);
        put('+', 0);
        put('*', 1);
        put('/', 1);
    }};

    // 3 + 2 * 2
    public int calculate(String s) {
        // cc
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        char[] chs = s.toCharArray();
        int num = 0;
        int i = 0;

        while (i < chs.length) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                num = chs[i++] - '0';

                while (i < chs.length && (chs[i] >= '0' && chs[i] <= '9')) {
                    num *= 10;
                    num += chs[i++] - '0';
                }

                numStack.push(num);
            } else if (chs[i] == '+' || chs[i] == '-' || chs[i] == '*' || chs[i] == '/') {
                handleOps(numStack, opStack, chs[i]);
                opStack.push(chs[i++]);
            } else {
                i++;
            }
        }

        while (!opStack.isEmpty()) {
            handleOps(numStack, opStack, opStack.peek());
        }

        return numStack.pop();
    }

    private void handleOps(Stack<Integer> numStack, Stack<Character> opStack, char op) {
        while (!opStack.isEmpty() && map.get(op) <= map.get(opStack.peek())) {
            int sNum = numStack.pop();
            int fNum = numStack.pop();
            char opTmp = opStack.pop();

            numStack.push(calculate(opTmp, fNum, sNum));
        }
    }

    private int calculate(char op, int fNum, int sNum) {
        if (op == '+') {
            return fNum + sNum;
        } else if (op == '-') {
            return fNum - sNum;
        } else if (op == '*') {
            return fNum * sNum;
        } else {
            return fNum / sNum;
        }
    }

    // "3 + 2 * 2"
    public int calculate2(String s) {

        int len = s.length();
        if (s == null || len == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    // No stack approach
    public int calculate3(String s) {
        int length = s.length();
        if (s == null || length == 0) return 0;
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }


    // LC no stack solution
    // 3 - 2 * 3 / 2 + 2
    public int calculate4(String s) {
        // cc
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        int result = 0;
        int lastNumber = 0;
        int currentNumber = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar >= '0' && currentChar <= '9') {
                currentNumber = currentNumber * 10 + currentChar - '0';
            } else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                if (operator == '+' || operator == '-') {
                    result += lastNumber;
                    lastNumber = operator == '+' ? currentNumber : -currentNumber;
                } else if (operator == '*') {
                    lastNumber *= currentNumber;
                } else if (operator == '/') {
                    lastNumber /= currentNumber;
                }

                operator = currentChar;
                currentNumber = 0;
            }
        }

        if (operator == '+' || operator == '-') {
            result += lastNumber;
            lastNumber = operator == '+' ? currentNumber : -currentNumber;
        } else if (operator == '*') {
            lastNumber *= currentNumber;
        } else if (operator == '/') {
            lastNumber /= currentNumber;
        }

        result += lastNumber;
        return result;
    }


    // Snake's approach
    // 3 - 2 * 3 / 2 + 2
    public int calculate5(String s) {
        // cc
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        int cur = 0;
        int num = 0;
        int prevLastNum = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = s.charAt(i++) - '0';

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }

                i--;

                if (op == '+' || op == '-') {
                    cur = operate(op, cur, num);
                    prevLastNum = operate(op, 0, num);
                } else {
                    cur = cur - prevLastNum + operate(op, prevLastNum, num);
                    prevLastNum = operate(op, prevLastNum, num);
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                op = c;
            }
        }

        return cur;
    }

    private int operate(char op, int fNum, int sNum) {
        if (op == '+') {
            return fNum + sNum;
        } else if (op == '-') {
            return fNum - sNum;
        } else if (op == '*') {
            return fNum * sNum;
        } else {
            return fNum / sNum;
        }
    }


    public static void main(String[] args) {
        LC0227 solution = new LC0227();
        solution.calculate5(new String("3-2*3/2+2"));
    }
}
















