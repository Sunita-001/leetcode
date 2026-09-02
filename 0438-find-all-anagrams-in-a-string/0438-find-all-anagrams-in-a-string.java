class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        List<Integer> result = new ArrayList<>();
      
        // If s is shorter than p, no anagrams possible
        if (sLength < pLength) {
            return result;
        }
      
        // Count frequency of each character in pattern p
        int[] patternFreq = new int[26];
        for (int i = 0; i < pLength; i++) {
            patternFreq[p.charAt(i) - 'a']++;
        }
      
        // Initialize sliding window frequency array with first (pLength - 1) characters
        int[] windowFreq = new int[26];
        for (int i = 0; i < pLength - 1; i++) {
            windowFreq[s.charAt(i) - 'a']++;
        }
      
        // Slide the window through string s
        for (int i = pLength - 1; i < sLength; i++) {
            // Add the rightmost character to the window
            windowFreq[s.charAt(i) - 'a']++;
          
            // Check if current window is an anagram of p
            if (Arrays.equals(patternFreq, windowFreq)) {
                // Add the starting index of the current window
                result.add(i - pLength + 1);
            }
          
            // Remove the leftmost character from the window for next iteration
            windowFreq[s.charAt(i - pLength + 1) - 'a']--;
        }
      
        return result;
    }
}
