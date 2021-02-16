package Test;

public class Final_StaticFinal {
    class TestFinal {
        public final int a;

        TestFinal() {
            a = 1;
        }

        TestFinal(int num) {
            a = num;
        }
    }

    TestFinal t1 = new TestFinal();
    TestFinal t2 = new TestFinal(2);

    private static final int STATICNUMBER = 12;

    public static void main(String[] args) {
        int i;
        System.out.println(STATICNUMBER);
    }

}
