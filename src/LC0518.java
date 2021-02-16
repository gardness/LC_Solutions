import java.util.*;

public class LC0518 {
    public int change(int amount, int[] coins) {
        List<int[]> res = new LinkedList<>();
        Integer[] sortedCoins = new Integer[coins.length];

        for (int i = 0; i < coins.length; i++) {
            sortedCoins[i] = Integer.valueOf(coins[i]);
        }

        Arrays.sort(sortedCoins, Collections.reverseOrder());

        dfs(sortedCoins, 0, amount, new int[sortedCoins.length], res);

        return res.size();
    }

    private void dfs(Integer[] coins, int level, int remainder, int[] sol, List<int[]> res) {
        if (remainder == 0) {
            res.add(sol.clone());

            return;
        }

        if (level == coins.length) {
            return;
        }

        int levelSize = remainder / coins[level];

        for (int i = 0; i < levelSize + 1; i++) {
            sol[level] = i;
            dfs(coins, level + 1, remainder - i * coins[level], sol, res);
        }
    }


    private void dfs1(Integer[] coins, int level, int remainder, List<Integer> combs, List<int[]> res) {
        if (remainder < 0) {
            return;
        }

        if (remainder == 0) {
            int[] newSol = new int[combs.size()];

            for (int i = 0; i < combs.size(); i++) {
                newSol[i] = combs.get(i);
            }

            res.add(newSol);

            return;
        }

        for (int i = level; i < coins.length; i++) {
            combs.add(coins[i]);
            dfs1(coins, i, remainder - coins[i], combs, res);
            combs.remove(combs.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC0518 solution = new LC0518();

        solution.change(500, new int[]{3,5,7,8,9,10,11});
    }
}
