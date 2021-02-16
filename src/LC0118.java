import java.util.*;

public class LC0118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new LinkedList<>();
        }

        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> fstRow = new LinkedList<>();

        fstRow.add(1);
        res.add(fstRow);

        for (int i = 2; i < numRows + 1; i++) {
            List<Integer> list = new LinkedList<>();

            list.add(1);

            while (stack.size() > 1) {
                Integer top = stack.pop();

                list.add(top + stack.peek());
            }

            // clear stack
            if (!stack.isEmpty()) {
                stack.pop();
            }

            list.add(1);
            res.add(list);

            // reset stack
            for (Integer tmp : list) {
                stack.add(tmp);
            }
        }

        return res;
    }
}
