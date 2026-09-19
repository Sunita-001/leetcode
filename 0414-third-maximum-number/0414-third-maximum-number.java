class Solution {
    public int thirdMax(int[] nums) {
        // Initialize three variables to track the top 3 maximum values
        // Using Long.MIN_VALUE to handle edge cases with Integer.MIN_VALUE in the array
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
      
        // Iterate through all numbers in the array
        for (int num : nums) {
            // Skip duplicates - we only want distinct maximum values
            if (num == firstMax || num == secondMax || num == thirdMax) {
                continue;
            }
          
            // Update the three maximum values based on current number
            if (num > firstMax) {
                // Current number is the new largest, shift all values down
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                // Current number is the new second largest
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax) {
                // Current number is the new third largest
                thirdMax = num;
            }
        }
      
        // If third maximum exists, return it; otherwise return the first maximum
        // thirdMax will remain Long.MIN_VALUE if there are fewer than 3 distinct numbers
        return (int) (thirdMax != Long.MIN_VALUE ? thirdMax : firstMax);
    }
}
