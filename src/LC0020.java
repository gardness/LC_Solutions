import java.util.LinkedList;
import java.util.Stack;

public class LC0020 {
    //
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if ((c == '}' && stack.peek() == '{') || (c == ')' && stack.peek() == '('
                        || (c == ']' && stack.peek() == '['))) {
                    stack.pop();
                    continue;
                }
            }

            stack.push(c);
        }

        return stack.isEmpty();
    }
}
