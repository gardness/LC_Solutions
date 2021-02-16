public class LC0191 {
    // you need to treat n as an unsigned value
    // left shift mask
    public int hammingWeight(int n) {
        int mask = 1;
        int cnt = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                cnt++;
            }
        }

        return cnt;
    }

    // signed right shift mask
    public int hammingWeight1(int n) {
        int cnt = 0;

        for (int i = 0; i < 32; i++) {
            if ((((n >> i) & 1) != 0)) {
                cnt++;
            }
        }

        return cnt;
    }

    // unsigned right shift mask & return
    public int hammingWeight2(int n) {
        int cnt = 0;

        for (int i = 0; i < 32; i++) {
            if ((n >>> i) == 0) {
                break;
            }

            if (((n >>> i) & 1) != 0) {
                cnt++;
            }
        }

        return cnt;
    }
}
