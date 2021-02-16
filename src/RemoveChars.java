public class RemoveChars {
    // Given a string s, remove specified characters from the string
    public String removeChar(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int slow = 0;

        for (int fast = 0; fast < s.length(); fast++) {
            if (chars[fast] != 'o' && chars[fast] != 'f') {
                chars[slow++] = chars[fast];
            }
        }

        return new String(chars, 0, slow);
    }

    public static void main(String[] args) {
        RemoveChars solution = new RemoveChars();

        solution.removeChar("yougetgetoffer");
    }
}
