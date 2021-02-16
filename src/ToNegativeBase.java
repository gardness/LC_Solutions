public class ToNegativeBase {
    public String toNegativeBase(int n, int negBase) {    //TODO: output int
        StringBuilder sb = new StringBuilder();
        int remainder = n;

        while (remainder != 0) {
            int next = remainder / negBase;
            int digit = remainder - next * negBase;

            if (digit < 0) {
                next++;
                digit = remainder - next * negBase;
            }

            sb.insert(0, (char) (digit + '0'));
            remainder = next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ToNegativeBase solution = new ToNegativeBase();

        System.out.println(solution.toNegativeBase(13, -2));
    }
}
