import javax.swing.tree.TreeNode;
import java.util.Stack;

public class LC0439 {
    /*
            digit letter   :   push number into numStack
                 ?         :   pop 2 number out of numStack, and evaluate with the closest condition before it
                 :         :   do nothing

              F?1:T?4:5
     */
    public String parseTernary(String expression) {
        // cc
        if (expression == null || expression.length() == 0) {
            throw new IllegalArgumentException();
        }

        Stack<String> stack = new Stack<>();

        for (int i = expression.length() - 1; i > 0; i--) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || Character.isAlphabetic(c)) {
                StringBuilder sb = new StringBuilder();
                sb.append(expression.charAt(i--));

                while (i > 0 && (Character.isDigit(expression.charAt(i)) || Character.isAlphabetic(expression.charAt(i)))) {
                    sb.append(expression.charAt(i--));
                }

                i++;
                stack.push(sb.toString());
            } else if (c == '?') {
                char op = expression.charAt(i - 1);

                if (op == 'T') {
                    String res = stack.pop();
                    stack.pop();
                    stack.push(res);
                } else {
                    stack.pop();
                }

                i--;
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        LC0439 solution = new LC0439();
        solution.parseTernary("T?2:3");
    }
}
