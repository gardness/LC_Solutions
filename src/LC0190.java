public class LC0190 {
    // you need treat n as an unsigned value

    // One-way
    public int reverseBits(int n) {
        if (n == 0) {   //  Integer.MAX_VALUE ?
            return 0;
        }

        int res = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                res |= 1 << (31 - i);
            }
        }

        return res;
    }

    // Two-way
    public int reverseBits1(int n) {
        if (n == 0) {
            return 0;
        }

//        for (int i = 0; i < 16; i++) {
//            int leftBit = (n & (1 << (31 - i))) != 0 ? 1 : 0;
//            int rightBit = (n & (1 << i)) != 0 ? 1 : 0;
//
//            if (leftBit != rightBit) {
//                n ^= 1 << (31 - i);
//                n ^= 1 << i;
//            }
//        }

        for (int i = 0; i < 16; i++) {
            int leftBit = 1 & (n >> (31 - i));
            int rightBit = 1 & (n >> i);

            if (leftBit != rightBit) {
                n ^= 1 << (31 - i);
                n ^= 1 << i;
            }
        }

        return n;
    }
}
