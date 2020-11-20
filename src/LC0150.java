import java.util.Stack;

public class LC0150 {
    public int evalRPN(String[] tokens) {
        // cc
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException();
        }

        Stack<Integer> numStack = new Stack<>();

        for (String str : tokens) {
            if (Character.isDigit(str.charAt(0)) || (str.length() > 1) && (Character.isDigit(str.charAt(1)))) {
                int sign = 1;
                int num = str.charAt(0) - '0';

                if (!Character.isDigit(str.charAt(0))) {
                    sign = -1;
                    num = 0;
                }

                for (int i = 1; i < str.length(); i++) {
                    num = num * 10 + sign * (str.charAt(i) - '0');
                }

                numStack.push(num);
            } else if (str.charAt(0) == '+') {
                int sndNum = numStack.pop();
                int fstNum = numStack.pop();

                numStack.push(fstNum + sndNum);
            } else if (str.charAt(0) == '-') {
                int sndNum = numStack.pop();
                int fstNum = numStack.pop();

                numStack.push(fstNum - sndNum);
            } else if (str.charAt(0) == '*') {
                int sndNum = numStack.pop();
                int fstNum = numStack.pop();

                numStack.push(fstNum * sndNum);
            } else if (str.charAt(0) == '/') {
                int sndNum = numStack.pop();
                int fstNum = numStack.pop();

                numStack.push(fstNum / sndNum);
            }
        }

        return numStack.pop();
    }

    public static void main(String[] args) {
        LC0150 solution = new LC0150();
        solution.evalRPN(new String[]{"3","-4","+"});
    }
}
