public class LC0012 {
    public String intToRoman(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(romans[i]);
            }

            i++;
        }

        return sb.toString();
    }
}
