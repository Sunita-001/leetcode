class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store number value as key and its index as value
        Map<Integer, Integer> numberToIndexMap = new HashMap<>();

        // Iterate through the array
        for (int i = 0; ; ++i) {
            int currentNumber = nums[i];
            int complement = target - currentNumber;

            // Check if the complement exists in the map
            if (numberToIndexMap.containsKey(complement)) {
                // Found the pair that sums to target
                // Return the indices: [index of complement, current index]
                return new int[] {numberToIndexMap.get(complement), i};
            }

            // Store current number and its index in the map for future lookups
            numberToIndexMap.put(currentNumber, i);
        }
    }
}
