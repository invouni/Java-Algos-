### lps (Longest Palindromic Subsequence)

This Java program calculates the Longest Palindromic Subsequence (lps) of a given string. Below is a detailed explanation of the code and how it works.

#### Explanation

1. **Class Definition and Method Declaration**:
   - The class is named `lps`.
   - A private static method `lps` is defined to compute the longest palindromic subsequence length recursively using memoization.

2. **Parameters of the `lps` Method**:
   - `String s`: The input string.
   - `int i`: The starting index.
   - `int j`: The ending index.
   - `int n`: The length of the string.
   - `int[][] dp`: A 2D array for memoization to store intermediate results.

3. **Base Cases and Memoization Check**:
   - If `i` is greater than `j`, the function returns 0, meaning there is no subsequence.
   - If the value `dp[i][j]` is not `-1`, it means the result is already computed, and it is returned to avoid redundant calculations.

4. **Recursive Calculation**:
   - If the characters at indices `i` and `j` are the same:
     - If `i` is not equal to `j`, it adds 2 to the result of the recursive call for the substring `s[i+1...j-1]`.
     - If `i` is equal to `j`, it adds 1.
   - If the characters are different:
     - It calculates the maximum between the results of the recursive calls for `s[i+1...j]` and `s[i...j-1]`.

5. **Main Method**:
   - The string `str` is initialized with `"codingandonlycodinggang"`.
   - The length `n` of the string is calculated.
   - A 2D array `dp` of size `(n+1) x (n+1)` is initialized and filled with `-1` to indicate uncomputed results.
   - The `lps` method is called with initial indices `0` and `n-1`, and the result is printed.

#### Code

```java
import java.util.Arrays;

public class LPS {
    private static int lps(String s, int i, int j, int n, int [][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = (i != j ? 2 : 1) + lps(s, i + 1, j - 1, n, dp);
        } else {
            return dp[i][j] = Math.max(lps(s, i + 1, j, n, dp), lps(s, i, j - 1, n, dp));
        }
    }

    public static void main(String[] args) {
        String str = "codingandonlycodinggang";
        int n = str.length();
        int dp[][] = new int[n + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("Lpsis " + lps(str, 0, n - 1, n, dp));
    }
}
```

#### Output

When you run this program, it will output the length of the Longest Common Palindromic Subsequence for the string `"codingandonlycodinggang"`.

```plaintext
LCS is 11
```

The program uses dynamic programming to efficiently compute the result by storing and reusing previously computed values, thereby reducing the time complexity compared to a naive recursive solution.
