import java.util.Stack;

public class LC0255 {
    // [5,2,1,3,6]
    public boolean verifyPreorder(int[] preorder) {
        // cc
        if (preorder == null || preorder.length == 0) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        int lowerBound = Integer.MIN_VALUE;

        for (int num : preorder) {
            if (num < lowerBound) {
                return false;
            }

            while (!stack.isEmpty() && stack.peek() < num) {
                lowerBound = stack.pop();
            }

            stack.push(num);
        }

        return true;
    }


    // [5,2,1,3,6]
    // space complexity : O(1)
    public boolean verifyPreorder1(int[] preorder) {
        // cc
        if (preorder == null || preorder.length == 0) {
            return true;
        }

        int lowerBound = Integer.MIN_VALUE;
        int top = -1;

        for (int num : preorder) {
            if (num < lowerBound) {
                return false;
            }

            while (top != -1 && preorder[top] < num) {
                lowerBound = preorder[top--];
            }

            preorder[++top] = num;
        }

        return true;
    }
}
