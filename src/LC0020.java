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


    // "([)]"
    public boolean isValid1(String s) {
        // cc
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char tmp = stack.pop();

                    if ((c == ')' && tmp == '(') || (c == ']' && tmp == '[') || (c == '}' && tmp == '{')) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

}
