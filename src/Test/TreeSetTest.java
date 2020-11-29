package Test;

import java.util.*;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>((a, b) -> b.compareTo(a));

        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");

        Iterator<String> itr = treeSet.descendingIterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());

            String element = itr.next();

            if (element.equals("Second")) {
                itr.remove();
            }
        }
    }
}
