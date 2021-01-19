package dynamicProgramming.coinChange;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeByMemo {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dp(amount, coins, memo);
    }

    private int dp(int amount, int[] coins, Map<Integer, Integer> memo) {
        if (memo.containsKey(amount))
            return memo.get(amount);
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subRes = dp(amount - coin, coins, memo);
            if (subRes == -1) continue;
            res = Math.min(res, subRes + 1);
        }
        memo.put(amount, res);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new CoinChangeByMemo().coinChange(new int[]{1, 2, 5}, 11));
    }

}
