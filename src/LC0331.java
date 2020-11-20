public class LC0331 {
    public boolean isValidSerialization(String preorder) {
        // cc
        if (preorder == null || preorder.length() == 0) {
            return true;
        }

        String[] strs = preorder.split(",");
        int delta = 1;

        for (int i = 0; i < strs.length - 1; i++) {
            if (!strs[i].equals("#")) {
                delta++;
            } else {
                delta--;

                if (delta <= 0) {
                    return false;
                }
            }
        }

        return delta == 1 && strs[strs.length - 1].equals("#");
    }
}
