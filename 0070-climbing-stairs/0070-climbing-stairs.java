class Solution {
    /**
     * Calculate the number of distinct ways to climb to the top of a staircase with n steps.
     * You can climb either 1 or 2 steps at a time.
     * This uses dynamic programming with space optimization (Fibonacci sequence).
     * 
     * @param n The total number of steps to reach the top
     * @return The number of distinct ways to climb the stairs
     */
    public int climbStairs(int n) {
        // Initialize two variables to track the previous two states
        // previousTwo represents f(i-2), initially 0 ways to reach step -1
        int previousTwo = 0;
        // previousOne represents f(i-1), initially 1 way to reach step 0 (starting position)
        int previousOne = 1;
      
        // Iterate n times to calculate the number of ways to reach step n
        for (int step = 0; step < n; ++step) {
            // Calculate current number of ways: f(i) = f(i-1) + f(i-2)
            // This represents: ways to reach current step = 
            // (ways to reach previous step + take 1 step) + (ways to reach two steps back + take 2 steps)
            int current = previousTwo + previousOne;
          
            // Update the sliding window for the next iteration
            previousTwo = previousOne;  // Move f(i-1) to f(i-2)
            previousOne = current;      // Move f(i) to f(i-1)
        }
      
        // After n iterations, previousOne contains the number of ways to reach step n
        return previousOne;
    }
}
