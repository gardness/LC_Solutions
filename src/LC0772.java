import java.util.HashMap;
import java.util.Stack;

public class LC0772 {
    private HashMap<Character, Integer> map = new HashMap<>() {{
        put('+', 0);
        put('-', 0);
        put('*', 1);
        put('/', 1);
    }};

//    public int calculate(String s) {
//        // cc
//        if (s == null || s.length() == 0) {
//            throw new IllegalArgumentException();
//        }
//
//        Stack<Character> opStack = new Stack<>();
//        Stack<Integer> numStack = new Stack<>();
//        int num = 0;
//        int i = 0;
//
//        while (i < s.length()) {
//            char c = s.charAt(i);
//
//            if (Character.isDigit(c)) {
//                num = s.charAt(i) - '0';
//
//                while ()
//            }
//        }
//
//    }
}
