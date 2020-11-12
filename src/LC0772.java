import java.util.HashMap;
import java.util.Stack;

public class LC0772 {
    private HashMap<Character, Integer> map = new HashMap<>() {{
        put('(', -1);
        put('+', 0);
        put('-', 0);
        put('*', 1);
        put('/', 1);
    }};

    // 2*(5+5*2)/3-(6/2+8)
    public int calculate(String s) {
        // cc
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        numStack.push(0);                   //  In case the first character is '-'
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = s.charAt(i) - '0';

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }

                i--;
                numStack.push(num);
            } else if (c == '+' || c == '-' || c =='*' || c == '/') {
                while (!opStack.isEmpty() && map.get(opStack.peek()) >= map.get(c)) {
                    handleOp(numStack, opStack);
                }

                opStack.push(c);
            } else if (c == '(') {
                opStack.push(c);
            } else if (c == ')') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    handleOp(numStack, opStack);
                }
                opStack.pop();
            }
        }

        while (!opStack.isEmpty()) {
            handleOp(numStack, opStack);
        }

        return numStack.pop();
    }

    private void handleOp(Stack<Integer> numStack, Stack<Character> opStack) {
        char op = opStack.pop();
        int sndNum = numStack.pop();
        int fstNum = numStack.pop();

        if (op == '+') {
            numStack.push(fstNum + sndNum);
        } else if (op == '-') {
            numStack.push(fstNum - sndNum);
        } else if (op == '*') {
            numStack.push(fstNum * sndNum);
        } else {
            numStack.push(fstNum / sndNum);
        }
    }


}
