### ZAlgorithm README

## Overview

The Z algorithm is a linear time string matching algorithm that efficiently finds all occurrences of a pattern in a given text. This implementation constructs the Z-array to facilitate pattern matching.

## How It Works

1. **Z-array Construction**: The Z-array for a string `S` of length `n` is constructed where `Z[i]` is the length of the longest substring starting from `S[i]` that matches the prefix of `S`.
2. **Pattern Matching**: By concatenating the pattern and the text with a special character `$` in between (`P$T`), the Z-array is used to find positions where the pattern matches the text.

## Code Explanation

### `getZArray` Method

This method constructs the Z-array for a given string.

#### Parameters

- `String s`: The input string for which the Z-array is to be constructed.
- `int n`: The length of the input string.

#### Process

1. Initialize the Z-array and variables `l` and `r` to 0.
2. Loop through each position `i` from 1 to `n-1`:
   - If `i` is within the current Z-box (`i < r`), set `z[i]` to the minimum of `r - i` and `z[i - l]`.
   - Extend the Z-box by incrementing `z[i]` while characters match.
   - If the new Z-box extends beyond `r`, update `l` and `r`.

#### Return

- Returns the constructed Z-array.

```java
public static int[] getZArray(String s, int n) {
    int[] z = new int[n];
    int l = 0, r = 0;
    for (int i = 0; i < n; i++) {
        if (i < r) {
            z[i] = Math.min(r - i, z[i - l]);
        }
        while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
            z[i]++;
        }
        if (i + z[i] > r) {
            l = i;
            r = i + z[i];
        }
    }
    return z;
}
```

### `main` Method

This method demonstrates the use of the Z algorithm to find all occurrences of a pattern in a text.

1. Concatenate the pattern and text with `$` in between.
2. Construct the Z-array for the concatenated string.
3. Loop through the Z-array to find positions where the pattern matches the text.

```java
public static void main(String[] args) {
    String str = "aaabbaabababaabmagvanaaaabhaaa";
    String pat = "aaa";
    String concated = pat + "$" + str;
    int[] z = getZArray(concated, concated.length());
    for (int i = 0; i < z.length; i++) {
        if (z[i] == pat.length()) {
            System.out.println("Pattern found at " + (i - pat.length() - 1));
        }
    }
}
```

### Example

For the given string `str = "aaabbaabababaabmagvanaaaabhaaa"` and pattern `pat = "aaa"`, the output will be:

```
Pattern found at 0
Pattern found at 21
Pattern found at 22
Pattern found at 27
```

This indicates that the pattern "aaa" is found at indices 0, 21, 22, and 27 in the string.

## Conclusion

The Z algorithm is a powerful tool for pattern matching in linear time. By preprocessing the string to create the Z-array, it allows efficient searches and comparisons. This implementation demonstrates the use of the Z algorithm to find all occurrences of a pattern in a given text.
