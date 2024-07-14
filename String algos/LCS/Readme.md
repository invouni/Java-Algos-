# Longest Common Subsequence (LCS) in Java

This repository contains a Java program to find the Longest Common Subsequence (LCS) between two strings using dynamic programming.

## Program Description

The `LCS` class includes a method `lcs` to calculate the length of the LCS between two given strings `s1` and `s2`. It utilizes a recursive approach with memoization to store previously computed results and improve efficiency.

### Methods

- **lcs(String s1, String s2, int i, int j, int m, int n, int[][] dp)**: A private static method that computes the LCS length using recursion and memoization.
- **main(String[] args)**: The main method to run the program. It initializes two strings, creates a memoization table, and calls the `lcs` method to find and print the LCS length.

## Usage

1. Clone the repository.
2. Compile and run the `LCS` class.

### Example

```java
import java.util.Arrays;

public class LCS {
    private static int lcs(String s1, String s2, int i, int j, int m, int n, int[][] dp) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcs(s1, s2, i + 1, j + 1, m, n, dp);
        } else {
            int ans1 = lcs(s1, s2, i + 1, j, m, n, dp);
            int ans2 = lcs(s1, s2, i, j + 1, m, n, dp);
            return dp[i][j] = Math.max(ans1, ans2);
        }
    }

    public static void main(String[] args) {
        String str = "aaabbaabababaabmagvanaaaabhaaa";
        String pat = "mangoaaabbamaga";
        int m = str.length(), n = pat.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("LCS is " + lcs(str, pat, 0, 0, m, n, dp));
    }
}
```

### Output

```
LCS is 11
```

In this example, the LCS length between the strings "aaabbaabababaabmagvanaaaabhaaa" and "mangoaaabbamaga" is 11.

## Explanation

1. **Initialization**: The main method initializes two strings and their lengths. It also initializes a 2D array `dp` for memoization, filling it with `-1`.
2. **LCS Calculation**: The `lcs` method is called with initial indices set to 0. It recursively calculates the LCS length by comparing characters of both strings and using memoization to store and reuse previously computed results.
3. **Result**: The length of the LCS is printed to the console.
