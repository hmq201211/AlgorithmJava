package dynamicProgramming.coinChange;

public class CoinChangeByBruteForce {

    public int coinChange(int[] coins, int amount) {
        return dp(amount, coins);
    }

    private int dp(int n, int[] coins) {
        if (n == 0)
            return 0;
        if (n < 0)
            return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subRes = dp(n - coin, coins);
            if (subRes < 0) continue;
            res = Math.min(res, subRes + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new CoinChangeByBruteForce().coinChange(new int[]{1, 2, 5}, 11));
    }
}
