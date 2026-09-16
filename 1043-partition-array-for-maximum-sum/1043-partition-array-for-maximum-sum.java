class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        // dp[i] represents the maximum sum we can achieve by partitioning arr[0...i-1]
        int[] dp = new int[n + 1];
      
        // Iterate through each position in the array
        for (int i = 1; i <= n; i++) {
            int maxValue = 0;
          
            // Try all possible partition sizes ending at position i
            // j represents the starting position of the current partition (1-indexed)
            for (int j = i; j > Math.max(0, i - k); j--) {
                // Update the maximum value in the current partition
                maxValue = Math.max(maxValue, arr[j - 1]);
              
                // Calculate the sum if we partition from j to i:
                // dp[j-1]: maximum sum before this partition
                // maxValue * (i - j + 1): sum of current partition (all elements become maxValue)
                dp[i] = Math.max(dp[i], dp[j - 1] + maxValue * (i - j + 1));
            }
        }
      
        // Return the maximum sum after partitioning the entire array
        return dp[n];
    }
}
