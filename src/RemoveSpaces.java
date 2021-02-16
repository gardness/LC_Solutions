public class RemoveSpaces {
    // Remove leading/trailing/and duplicate space with one remaining

    // Always keep the space after a non-whitespace character
    public String removeSpaces(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int slow = 0;

//        for (int fast = 0; fast < s.length(); fast++) {
//            if ((chars[fast] == ' ') && (fast == 0 || chars[fast - 1] == ' ')) {
//                continue;
//            }
//
//            chars[slow++] = chars[fast];
//        }

        for (int fast = 0; fast < s.length(); fast++) {
            if ((chars[fast] != ' ') || ((fast != 0) && (chars[fast - 1] != ' '))) {
                chars[slow++] = chars[fast];
            }
        }

        if (slow == 0) {
            return "";
        }

        if (chars[slow - 1] == ' ') {
            return new String(chars, 0, slow - 1);
        }

        return new String(chars, 0, slow);
    }


    // Always keep the space before a non-whitespace character
    public String removeSpaces1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int slow = 0;
        int fast = 0;

        while (chars[fast] == ' ') {
            fast++;
        }

        while (fast < s.length()) {
            if (fast + 1 < s.length() && chars[fast] == ' ' && chars[fast + 1] == ' ') {
                fast++;

                continue;
            }

            chars[slow++] = chars[fast];

            fast++;
        }

        if (slow == 0) {
            return "";
        }

        return chars[slow] == ' ' ?
                new String(chars, 0, slow - 1) : new String(chars, 0, slow);
    }

    public static void main(String[] args) {
        RemoveSpaces solution = new RemoveSpaces();

        solution.removeSpaces1("   you   get offer   ");
    }
}
