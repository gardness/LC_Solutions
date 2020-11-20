import java.util.List;
import java.util.Stack;

public class LC0385 {
    public class NestedInteger {
        public NestedInteger() {
        }

        public NestedInteger(int value) {
        }

        public boolean isInteger() {
            return true;
        }

        public Integer getInteger() {
            return 0;
        }

        public void setInteger(int value) {
        }

        public void add(NestedInteger ni) {
        }

        public List<NestedInteger> getList() {
            return null;
        }
    }

    /*
        digits  :   get the integer
                    if it's the first,  to the top element of the stack
                    if it's not, add the integer
        [       :   set isFirst to true, push an empty NestedInteger object to the stack
        ]       :   pop the top element out of the stack
        ,       :   set isFirst to false, then do nothing

        "[123,[456,[789,123]]]"
     */
    public NestedInteger deserialize(String s) {
        // cc
        if (s == null || s.length() == 0) {
            return null;
        }

        Stack<NestedInteger> stack = new Stack<>();
        boolean isFirst = true;
        int num = 0;
        int i = 0;

        // Preprocessing
        if (s.charAt(0) != '[') {
            num = s.charAt(i++) - '0';

            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i++) - '0';
            }

            return new NestedInteger(num);
        }

        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == ',') {
                isFirst = false;
                i++;
            } else if (Character.isDigit(c)) {
                num = s.charAt(i++) - '0';

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }

                if (isFirst) {
                    stack.peek().setInteger(num);
                } else {
                    stack.peek().getList().add(new NestedInteger(num));
                }
            } else if (c == '[') {
                stack.push(new NestedInteger());
            }
        }

        return null;
    }

}
