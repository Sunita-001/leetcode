class Solution {
    /**
     * Converts a decimal integer to its base-7 representation as a string.
     * 
     * @param num The decimal integer to convert (can be positive, negative, or zero)
     * @return The base-7 representation of the input number as a string
     */
    public String convertToBase7(int num) {
        // Handle the special case where input is 0
        if (num == 0) {
            return "0";
        }
      
        // Handle negative numbers by converting the positive value and prepending "-"
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }
      
        // Build the base-7 representation digit by digit
        StringBuilder result = new StringBuilder();
      
        // Extract digits from least significant to most significant
        while (num != 0) {
            // Get the remainder when dividing by 7 (the rightmost digit in base-7)
            result.append(num % 7);
          
            // Remove the rightmost digit by integer division
            num /= 7;
        }
      
        // Reverse the string since we built it from right to left
        return result.reverse().toString();
    }
}
