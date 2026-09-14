class Solution {
    /**
     * Determines if an array contains any duplicate elements.
     * 
     * @param nums The input array of integers
     * @return true if any value appears at least twice, false otherwise
     */
    public boolean containsDuplicate(int[] nums) {
        // Sort the array to place duplicate elements adjacent to each other
        Arrays.sort(nums);
      
        // Iterate through the sorted array and check adjacent elements
        for (int i = 0; i < nums.length - 1; i++) {
            // If two adjacent elements are equal, we found a duplicate
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
      
        // No duplicates found after checking all adjacent pairs
        return false;
    }
}
