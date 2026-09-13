class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        // Modulo value for preventing integer overflow
        final int MOD = (int) 1e9 + 7;
      
        // dp[i][j] represents the number of ways to get sum j using i dice
        int[][] dp = new int[n + 1][target + 1];
      
        // Base case: 0 dice with sum 0 has exactly 1 way (empty selection)
        dp[0][0] = 1;
      
        // Iterate through each die
        for (int diceCount = 1; diceCount <= n; diceCount++) {
            // Iterate through possible sums
            // Maximum possible sum with diceCount dice is diceCount * k
            for (int currentSum = 1; currentSum <= Math.min(target, diceCount * k); currentSum++) {
                // Try all possible face values for the current die
                for (int faceValue = 1; faceValue <= Math.min(currentSum, k); faceValue++) {
                    // Add the number of ways to achieve (currentSum - faceValue) 
                    // with (diceCount - 1) dice
                    dp[diceCount][currentSum] = (dp[diceCount][currentSum] + 
                                                  dp[diceCount - 1][currentSum - faceValue]) % MOD;
                }
            }
        }
      
        // Return the number of ways to achieve target sum with n dice
        return dp[n][target];
    }
}
