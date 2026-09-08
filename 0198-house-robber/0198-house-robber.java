class Solution {
    // Memoization array to store computed results for each house index
    private Integer[] memo;
    // Reference to the input array of house values
    private int[] houses;

    /**
     * Main method to calculate maximum money that can be robbed
     * without robbing two adjacent houses
     * @param nums Array where nums[i] represents money in house i
     * @return Maximum amount of money that can be robbed
     */
    public int rob(int[] nums) {
        this.houses = nums;
        // Initialize memoization array with null values
        this.memo = new Integer[nums.length];
        // Start recursive calculation from house 0
        return calculateMaxRobbery(0);
    }

    /**
     * Recursive helper method with memoization to calculate maximum robbery amount
     * starting from house at index i
     * @param houseIndex Current house index being considered
     * @return Maximum money that can be robbed from houseIndex to end
     */
    private int calculateMaxRobbery(int houseIndex) {
        // Base case: if index is beyond array bounds, no money can be robbed
        if (houseIndex >= houses.length) {
            return 0;
        }
      
        // Check if result for this house has already been computed
        if (memo[houseIndex] == null) {
            // Calculate and store the maximum of two choices:
            // Choice 1: Rob current house and skip next house (move to houseIndex + 2)
            int robCurrentHouse = houses[houseIndex] + calculateMaxRobbery(houseIndex + 2);
            // Choice 2: Skip current house and move to next house (houseIndex + 1)
            int skipCurrentHouse = calculateMaxRobbery(houseIndex + 1);
          
            // Store the maximum value in memoization array
            memo[houseIndex] = Math.max(robCurrentHouse, skipCurrentHouse);
        }
      
        return memo[houseIndex];
    }
}
