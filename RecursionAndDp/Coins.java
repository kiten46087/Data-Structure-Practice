package RecursionAndDp;

public class Coins {
    /* Dynamic programming. */
    public int makeChanges(int n, int[] denoms) {
        int[][] map = new int[n + 1][denoms.length];
        return makeChanges(n, denoms, 0, map);
    }

    private int makeChanges(int total, int[] denoms, int index, int[][] map) {
        if (map[total][index] > 0) return map[total][index];

        int coin = denoms[index];
        if (index == denoms.length - 1) {
            int remaining = total % coin;
            return remaining == 0 ? 1 : 0;
        }

        int numberOfWays = 0;
        for (int amount = 0; amount <= total; amount += coin) {
            numberOfWays += makeChanges(total - amount, denoms, index + 1, map);
        }

        map[total][index] = numberOfWays;

        return numberOfWays;
    }
}