import java.util.Stack;

public class LC0394 {
    /*
        stacks  :   numStack, sbStack

        digit   :   get the integer and push it into numStack
        letter  :   get the string and push it into sbStack
        [       :   push an empty stringbuilder to sbStack
        ]       :   pop the top element in both numStack and sbStack,
                    then calculate the new string and append it to the top of sbStack

     */
    public String decodeString(String s) {
        // cc
        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        sbStack.push(new StringBuilder());
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = s.charAt(i++) - '0';

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }

                i--;
                numStack.push(num);
            } else if (Character.isLetter(c)) {
                while (Character.isLetter(s.charAt(i))) {
                    sbStack.peek().append(s.charAt(i++));
                }

                i--;
            } else if (c == '[') {
                sbStack.push(new StringBuilder());
            } else if (c == ']') {
                StringBuilder str = sbStack.pop();
                int cnt = numStack.pop();

                while (cnt-- > 0) {
                    sbStack.peek().append(str);
                }
            }
        }

        return sbStack.peek().toString();
    }
}
