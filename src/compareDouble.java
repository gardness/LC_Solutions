public class compareDouble {
    private static void simpleFloatsComparison() {
        // Method 1
        double f1 = .0;

        for (int i = 1; i < 11; i++) {
            f1 += .1;
        }

        // Method 2
        double f2 = .1 * 11;

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);

        if (f1 == f2) {
            System.out.println("f1 and f2 are equal\n");
        } else {
            System.out.println("f1 and f2 are not equal\n");
        }
    }

    private static void thresholdBasedFloatsComparison() {
        final double THRESHOLD = .0001;

        // Method 1
        double f1 = .0;

        for (int i = 1; i <= 11; i++) {
            f1 += .1;
        }

        // Method 2
        double f2 = .1 * 11;

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);

        if (Math.abs(f1 - f2) < THRESHOLD) {
            System.out.println("f1 and f2 are equal\n");
        } else {
            System.out.println("f1 and f2 are not equal\n");
        }
    }

    public static void main(String[] args) {
        double d1 = 15.45;
        double d2 = 11.50;
        int retval = Double.compare(d1, d1);

        double min = Integer.MIN_VALUE;
        double max = Integer.MAX_VALUE;

        System.out.println(d1 > d2);
        simpleFloatsComparison();
        thresholdBasedFloatsComparison();
    }
}
