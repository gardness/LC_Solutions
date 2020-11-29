package Test;

import java.util.*;

public class ComparatorComparable {
    static class Player implements Comparable<Player> {
        private int ranking;
        private String name;
        private int age;

        Player(int ranking, String name, int age) {
            this.ranking = ranking;
            this.name = name;
            this.age = age;
        }

        public int getRanking() {
            return ranking;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(Player otherPlayer) {
            return getRanking() - otherPlayer.getRanking();
        }
    }

    static class PlayerAgeComparator implements Comparator<Player> {
        @Override
        public int compare(Player fPlayer, Player sPlayer) {
            return fPlayer.getAge() - sPlayer.getAge();
        }
    }

    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);

        footballTeam.add(player1);
        footballTeam.add(player3);
        footballTeam.add(player2);

        System.out.println("Before Sorting : " + footballTeam);
//        Collections.sort(footballTeam, new PlayerAgeComparator());
//        Collections.sort(footballTeam, new Comparator<Player>() {
//            @Override
//            public int compare(Player fPlayer, Player sPlayer) {
//                return fPlayer.getAge() - sPlayer.getAge();
//            }
//        });
        Collections.sort(footballTeam, (a, b) -> a.getAge() - b.getAge());
        System.out.println("After Sorting : " + footballTeam);



        int[] arr1 = new int[]{1, 2};
        int[] arr2 = new int[]{1, 2};
        HashSet<int[]> set = new HashSet<>();

        boolean bool1 = set.add(arr1);
        boolean bool2 = set.add(arr2);

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        HashSet<List<Integer>> set2 = new HashSet<>();

        boolean bool3 = set2.add(list1);
        boolean bool4 = set2.add(list2);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(3);

        minHeap.offer(0);
        minHeap.offer(0);
        minHeap.offer(0);
        minHeap.offer(0);
        minHeap.offer(0);
    }
}
