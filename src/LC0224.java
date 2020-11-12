import java.util.Stack;

public class LC0224 {
    // Most intuitive approach
    // 1 + ( 4 + 5 + 2 ) - 3
    public int calculate(String s) {
        // cc
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        int num = 0;
        int i = 0;

        while (i < s.length()) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                num = s.charAt(i++) - '0';

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }

                numStack.push(num);

            } else if (currentChar == '(') {
                opStack.push(currentChar);
                i++;
            } else if (currentChar == '+' || currentChar == '-') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    handleOp(numStack, opStack);
                }

                opStack.push(currentChar);
                i++;
            } else if (currentChar == ')') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    handleOp(numStack, opStack);
                }

                if (!opStack.isEmpty()) {
                    opStack.pop();
                }
                i++;
            } else {
                i++;
            }
        }

        while (!opStack.isEmpty()) {
            handleOp(numStack, opStack);
        }

        return numStack.pop();
    }

    private void handleOp(Stack<Integer> numStack, Stack<Character> opStack) {
        int sOpnd = numStack.pop();
        int fOpnd = numStack.pop();
        char op = opStack.pop();

        if (op == '-') {
            numStack.push(fOpnd - sOpnd);
        } else {
            numStack.push(fOpnd + sOpnd);
        }
    }

    // Best approach
    // Using a sign stack to solve the problem of associativity
    public int calculate5(String s) {
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> signStack = new Stack<Integer>();
        stack.push(0);
        signStack.push(1);

        for (int i = 0; i <= len; i++) {
            char c = i < len ? s.charAt(i) : '+';
            if (c <= '9' && c >= '0') {
                int num = 0;
                while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i++) - '0');
                }

                i--;
                stack.push(num);

            } else if (c == '(') {
                stack.push(0);
                signStack.push(1);
            } else if (c == '+' || c == '-' || c == ')') {
                int top = stack.pop();
                int sign = signStack.pop();
                stack.push(stack.pop() + top * sign);

                if (c == '+') signStack.push(1);
                if (c == '-') signStack.push(-1);
            }
        }

        return stack.pop();
    }

    // Approach 2: Stack and No String Reversal
    public int calculate6(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0; // For the on-going result
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {

                // Forming operand, since it could be more than one digit
                operand = 10 * operand + (int) (ch - '0');

            } else if (ch == '+') {

                // Evaluate the expression to the left,
                // with result, sign, operand
                result += sign * operand;

                // Save the recently encountered '+' sign
                sign = 1;

                // Reset operand
                operand = 0;

            } else if (ch == '-') {

                result += sign * operand;
                sign = -1;
                operand = 0;

            } else if (ch == '(') {

                // Push the result and sign on to the stack, for later
                // We push the result first, then sign
                stack.push(result);
                stack.push(sign);

                // Reset operand and result, as if new evaluation begins for the new sub-expression
                sign = 1;
                result = 0;

            } else if (ch == ')') {

                // Evaluate the expression to the left
                // with result, sign and operand
                result += sign * operand;

                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                result *= stack.pop();

                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();

                // Reset the operand
                operand = 0;
            }
        }
        return result + (sign * operand);
    }


    // My implementation of Snake's method
    // (1-(4-5+2)-3)
    public int calculate7(String s) {
        // cc
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> signStack = new Stack<>();
        numStack.push(0);
        signStack.push(1);
        int num = 0;
        int result = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-' || c == ')') {
                int secNum = numStack.pop();
                int firNum = numStack.pop();
                int secSign = signStack.pop();

                numStack.push(firNum + secSign * secNum);

                if (c == '-') {
                    signStack.push(-1);
                }

                if (c == '+') {
                    signStack.push(1);
                }
            } else if (c == '(') {
                numStack.push(0);
                signStack.push(1);
            } else if (Character.isDigit(c)) {
                num = s.charAt(i++) - '0';

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }

                numStack.push(num);
                i--;
            }
        }

        return numStack.pop() * signStack.pop() + numStack.pop();
    }


    public static void main(String[] args) {
        LC0224 solution = new LC0224();
        solution.calculate7("1 + 1");
//        solution.calculate5(new String("(1-(4-5+2)-3)"));
    }
}
