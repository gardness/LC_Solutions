import java.util.*;

public class LC0022 {
    private static final char[] pars = new char[]{'(', ')'};

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();

        dfs(n, 0, 0, new StringBuilder(), res);

        return res;
    }

    // Pre-Recursion pruning, less readable, more efficient
    private void dfs(int n, int numLP, int numRP, StringBuilder sb, List<String> res) {
        if (numLP + numRP == 2 * n) {
            res.add(sb.toString());

            return;
        }

        for (char ch : pars) {
            if (ch == '(') {
                if (numLP == n) {
                    continue;
                }

                numLP++;
            } else {
                if (numRP == n) {
                    continue;
                }

                numRP++;
            }

            sb.append(ch);

            if (isValid(sb.toString())) {
                dfs(n, numLP, numRP, sb, res);
            }

            sb.deleteCharAt(sb.length() - 1);

            if (ch == '(') {
                numLP--;
            } else {
                numRP--;
            }
        }
    }

    // Post-Recursion pruning, more readable, less efficient
    private void dfs1(int n, int numLP, int numRP, StringBuilder sb, List<String> res) {
        if (numLP > n || numRP > n || !isValid(sb.toString())) {
            return;
        }

        if (numLP + numRP == 2 * n) {
            res.add(sb.toString());

            return;
        }

        for (char ch : pars) {
            sb.append(ch);

            if (ch == '(') {
                dfs1(n, numLP + 1, numRP, sb, res);
            } else {
                dfs1(n, numLP, numRP + 1, sb, res);
            }

            sb.setLength(sb.length() - 1);
        }
    }

    private boolean isValid(String sb) {
        Stack<Character> stack = new Stack<>();

        for (char ch : sb.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return true;
    }

    // Best version of pre-recursion pruning I've seen
    private void dfs2(int n, int numLP, int numRP, StringBuilder sb, List<String> res) {
        if (numLP == n && numRP == n) {
            res.add(sb.toString());
        }

        if (numLP < n) {
            sb.append('(');
            dfs2(n, numLP + 1, numRP, sb, res);
            sb.setLength(sb.length() - 1);
        }

        if (numRP < numLP) {
            sb.append(')');
            dfs2(n, numLP, numRP + 1, sb, res);
            sb.setLength(sb.length() - 1);
        }
    }

    // Best version of post-recursion pruning I've seen
    private void dfs3(int n, int numLP, int numRP, StringBuilder sb, List<String> res) {
        if (numRP > numLP || numLP > n || numRP > n) {
            return;
        }

        if (numLP == n && numRP == n) {
            res.add(sb.toString());

            return;
        }

        sb.append('(');
        dfs3(n, numLP + 1, numRP, sb, res);
        sb.setLength(sb.length() - 1);
        sb.append(')');
        dfs3(n, numLP, numRP + 1, sb, res);
        sb.setLength(sb.length() - 1);
    }

    public static void main(String[] args) {
        LC0022 solution = new LC0022();

        solution.generateParenthesis(3);
    }
}
