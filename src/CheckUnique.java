public class CheckUnique {
    // An element in chars can be any character in the extended ASCII table
    public boolean checkUnique(char[] chars) {
        if (chars == null || chars.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] bitSet = new int[9];      //  Since the left-most digit is reserved for sign, we need one more integer here.

        for (char ch : chars) {
            int row = ch / 31;
            int col = ch % 31;

//            // Not using mask
//            if ((bitSet[row] << (31 - col)) < 0) {      //  Signed left shift operator "<<" can change the sign of the number
//                return false;
//            }

            // Using mask
            if ((bitSet[row] & (1 << col)) != 0) {
                return false;
            }

//            // Not using mask
//            bitSet[row] |= (int) Math.pow(2, col);

            // Using mask
            bitSet[row] |= 1 << col;
        }

        return true;
    }

    public static void main(String[] args) {
        CheckUnique solution = new CheckUnique();

        solution.checkUnique(new char[]{'a', 'b', '+', '%', 'f', 'e'});
    }
}
