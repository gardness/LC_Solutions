import java.util.*;

public class LC0205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> keyMap = new HashMap<>();
        HashMap<Character, Character> valueMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if ((keyMap.containsKey(sChar) && keyMap.get(sChar) != tChar)
                    || (valueMap.containsKey(tChar) && valueMap.get(tChar) != sChar)) {
                return false;
            }

            keyMap.put(sChar, tChar);
            valueMap.put(tChar, sChar);
        }

        return true;
    }

    public static void main(String[] args) {
        LC0205 solution = new LC0205();

        solution.isIsomorphic("paper", "title");
    }
}
