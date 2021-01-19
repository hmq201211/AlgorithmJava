package dynamicProgramming.coinChange;


import java.util.Arrays;


public class CoinChangeByUpsideDown {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 0; i < memo.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0)
                    continue;
                memo[i] = Math.min(memo[i], memo[i - coin] + 1);
            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChangeByUpsideDown().coinChange(new int[]{1, 2, 5}, 11));
    }
}
