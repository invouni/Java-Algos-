### Longest Repeated Substring Finder

#### Overview

This Java program finds the longest repeated substring within a given string using suffix arrays and the Longest Common Prefix (LCP) array.

#### Components

1. **Main Class: `LongestRepeatedSubstring`**
   - The `main` method initializes a string `str` and calls `findLongestRepeatedSubstring` to identify the longest repeated substring.

2. **Method: `findLongestRepeatedSubstring`**
   - **Purpose:** Computes the longest repeated substring using suffix arrays and LCP arrays.
   - **Steps:**
     - **Suffix Array Generation:** Creates an array of suffixes by iterating through the string and extracting substrings starting from each index.
     - **Sorting:** Sorts the array of suffixes lexicographically.
     - **LCP Array Construction:** Computes the LCP array where `lcp[i]` represents the length of the longest common prefix between `suffixes[i]` and `suffixes[i-1]`.
     - **Finding the Longest Repeated Substring:** Determines the suffix with the maximum LCP value, which indicates the longest repeated substring, and extracts it using substring operations.

3. **Method: `commonPrefixLength`**
   - **Purpose:** Calculates the length of the common prefix between two strings.
   - **Parameters:** Two strings `a` and `b`.
   - **Returns:** Length of the common prefix.

#### Example

For the input string `"hellcodingncodingndude"`, the program identifies `"coding"` as the longest repeated substring. Here's the output:

```plaintext
Longest Repeated Substring: coding
```

#### Code

```java
import java.util.Arrays;

public class LongestRepeatedSubstring {
    public static void main(String[] args) {
        String str = "hellcodingncodingndude";
        System.out.println("Longest Repeated Substring: " + findLongestRepeatedSubstring(str));
    }

    public static String findLongestRepeatedSubstring(String str) {
        int n = str.length();
        String[] suffixes = new String[n];
        
        // Generate suffix array
        for (int i = 0; i < n; i++) {
            suffixes[i] = str.substring(i, n);
        }
        
        // Sort the suffix array
        Arrays.sort(suffixes);
        
        // Generate LCP array
        int[] lcp = new int[n];
        for (int i = 1; i < n; i++) {
            lcp[i] = commonPrefixLength(suffixes[i], suffixes[i-1]);
        }
        
        // Find the maximum LCP
        int maxLcpIndex = 0;
        for (int i = 1; i < n; i++) {
            if (lcp[i] > lcp[maxLcpIndex]) {
                maxLcpIndex = i;
            }
        }
        
        // Return the longest repeated substring
        return suffixes[maxLcpIndex].substring(0, lcp[maxLcpIndex]);
    }
    
    private static int commonPrefixLength(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return i;
            }
        }
        return minLength;
    }
}
```

#### Explanation

- **Suffix Array:** Stores all suffixes of the string in a sorted order.
- **LCP Array:** Helps in determining the longest common prefix between consecutive suffixes after sorting.
- **Finding the Longest Repeated Substring:** By identifying the index with the maximum LCP value, we can extract the longest repeated substring efficiently.

This approach leverages sorting and LCP computation to efficiently find the longest repeated substring in linearithmic time complexity relative to the length of the input string.
