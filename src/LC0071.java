import java.util.Stack;

public class LC0071 {

    /*
        letter :    push currrent folder name into stack
          ..   :    pop top elment out of stack
          . /  :    do nothing
     */
    public String simplifyPath(String path) {
        // cc
        if (path == null || path.length() == 0) {
            throw new IllegalArgumentException();
        }

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);

            if ((c != '.' && isValid(c)) || (i + 1 < path.length() && (c == '.' && path.charAt(i + 1) != '.' && path.charAt(i + 1) != '/'))
                    || (i + 2 < path.length() && (c == '.' && path.charAt(i + 1) == '.' && path.charAt(i + 2) != '/'))) {
                StringBuilder sb = new StringBuilder();
                sb.append(path.charAt(i++));

                while (i < path.length() && path.charAt(i) != '/') {
                    sb.append(path.charAt(i++));
                }

                stack.push(sb.toString());
            } else if (i + 1 < path.length() && (c == '.' && path.charAt(i + 1) == '.')) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        Stack<String> tmp = new Stack<>();

        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        sb.append('/');

        while (!tmp.isEmpty() && tmp.size() > 1) {
            sb.append(tmp.pop() + '/');
        }

        if (!tmp.isEmpty()) {
            sb.append(tmp.pop());
        }

        return sb.toString();
    }

    private boolean isValid(char c) {
        if (c == '_' || (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }
}
