class Solution {
    public String reformat(String s) {
        // Separate digits and letters into two StringBuilders
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
      
        // Iterate through each character and categorize them
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            } else {
                letters.append(c);
            }
        }
      
        // Get the lengths of digits and letters
        int digitCount = digits.length();
        int letterCount = letters.length();
      
        // If the difference in counts is more than 1, reformatting is impossible
        if (Math.abs(digitCount - letterCount) > 1) {
            return "";
        }
      
        // Build the result string by alternating between digits and letters
        StringBuilder result = new StringBuilder();
      
        // Alternate characters from both groups
        // The group with more characters goes first
        for (int i = 0; i < Math.min(digitCount, letterCount); i++) {
            if (digitCount > letterCount) {
                // Start with digit if there are more digits
                result.append(digits.charAt(i));
                result.append(letters.charAt(i));
            } else {
                // Start with letter if there are more letters (or equal)
                result.append(letters.charAt(i));
                result.append(digits.charAt(i));
            }
        }
      
        // Append the remaining character if one group has an extra character
        if (digitCount > letterCount) {
            result.append(digits.charAt(digitCount - 1));
        }
        if (digitCount < letterCount) {
            result.append(letters.charAt(letterCount - 1));
        }
      
        return result.toString();
    }
}
