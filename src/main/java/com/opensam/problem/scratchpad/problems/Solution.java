class Solution {
  public int coinChange(int[] coins, int amount) {
    if (coins == null || amount < 0)
      return -1;

    int[] dp = getDp(coins, amount);

    return coinChange(amount, coins, dp);
  }

  public int coinChange(int amount, int[] coins, int[] dp) {
    if (amount == 0)
      return 0;
    else if (amount < 0)
      return Integer.MAX_VALUE;
    else if (dp[amount] > 0)
      return dp[amount];
    else {
      int length = coins.length;
      int[] coinChanges = new int[length];
      for (int i = 0; i < length; i++) {
        coinChanges[i] = coinChange(amount - coins[i], coins, dp);
      }

      int min = getMin(coinChanges);
      dp[amount] = 1 + min;
      return min;
    }

  }

  private int[] getDp(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    for (int i = 0; i < coins.length; i++) {
      if (i <= amount)
        dp[i] = 1;
    }
    return dp;
  }

  private int getMin(int[] coinChanges) {
    int length = coinChanges.length;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < length; i++) {
      if (min > coinChanges[i])
        min = coinChanges[i];
    }

    return min;
  }
}
