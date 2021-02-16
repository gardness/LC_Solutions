import java.util.*;

public class LC0013 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if (s.length() == 1) {
            return map.get(s.charAt(0));
        }

        char prev = s.charAt(0);
        char cur = s.charAt(1);
        int i = 1;
        int res = map.get(prev);

        while (i < s.length()) {
            int curValue = map.get(cur);
            int prevValue = map.get(prev);

            if (curValue > prevValue) {
                res = res - prevValue + (curValue - prevValue);
            } else {
                res += curValue;
            }

            if (++i < s.length()) {
                cur = s.charAt(i);
                prev = s.charAt(i - 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC0013 solution = new LC0013();

        solution.romanToInt("MCMXCIV");
    }
}
