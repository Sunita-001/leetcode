class Solution {
    /**
     * Removes palindromic subsequences from a string containing only 'a' and 'b'.
     * Key insight: Since the string contains only two characters ('a' and 'b'),
     * we can remove all 'a's in one operation (forming a palindromic subsequence)
     * and all 'b's in another operation. Therefore, the maximum operations needed is 2.
     * If the string itself is already a palindrome, we need only 1 operation.
     * 
     * @param s the input string containing only 'a' and 'b' characters
     * @return the minimum number of operations to remove all characters
     */
    public int removePalindromeSub(String s) {
        // Use two pointers to check if the string is a palindrome
        int left = 0;
        int right = s.length() - 1;
      
        // Compare characters from both ends moving towards the center
        while (left < right) {
            // If characters don't match, string is not a palindrome
            // We need 2 operations: remove all 'a's, then remove all 'b's
            if (s.charAt(left) != s.charAt(right)) {
                return 2;
            }
            // Move pointers towards the center
            left++;
            right--;
        }
      
        // String is a palindrome, can be removed in 1 operation
        return 1;
    }
}
