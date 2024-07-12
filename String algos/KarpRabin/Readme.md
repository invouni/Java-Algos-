
```markdown
# Karp-Rabin Algorithm Implementation

This repository contains an implementation of the Karp-Rabin string matching algorithm in Java. The Karp-Rabin algorithm is used to search for occurrences of a "pattern" string within a "text" string efficiently using hashing.

## Table of Contents

- [Introduction](#introduction)
- [Code Explanation](#code-explanation)
  - [Creating the Hash](#creating-the-hash)
  - [Updating the Hash](#updating-the-hash)
  - [Karp-Rabin Algorithm](#karp-rabin-algorithm)
- [Usage](#usage)
- [Conclusion](#conclusion)

## Introduction

The Karp-Rabin algorithm is an efficient string matching algorithm that uses hashing to find patterns within a text. It calculates a hash for the pattern and a rolling hash for the text, comparing the hashes to determine if the pattern exists at a given position in the text.

## Code Explanation

### Creating the Hash

The `createHash` function generates the hash for a given string up to a specified length.

```java
public static long createHash(String s, int n) {
    long hash = 0;
    for (int i = 0; i < n; i++) {
        hash = hash + s.charAt(i) * (long) Math.pow(PRIME, i);
    }
    return hash;
}
```

- `s`: The input string.
- `n`: The length up to which the hash is calculated.
- `hash`: The generated hash value.

The function iterates over the string and calculates the hash by multiplying each character by the power of `PRIME` and summing the results.

### Updating the Hash

The `updateHash` function updates the hash when moving from one substring to the next.

```java
public static long updateHash(long prevHash, char prevChar, char newChar, int len) {
    long newHash = (prevHash - prevChar) / PRIME;
    newHash = newHash + newChar * (long) Math.pow(PRIME, len - 1);
    return newHash;
}
```

- `prevHash`: The previous hash value.
- `prevChar`: The character that is being removed from the hash window.
- `newChar`: The character that is being added to the hash window.
- `len`: The length of the pattern.

The function adjusts the hash by removing the influence of the old character and adding the influence of the new character.

### Karp-Rabin Algorithm

The `KarpRabinAlgo` function implements the Karp-Rabin algorithm to search for the pattern within the text.

```java
public static void KarpRabinAlgo(String s, String pat) {
    int n = s.length(), m = pat.length();
    long strHash = createHash(s, m);
    long patHash = createHash(pat, m);

    for (int i = 0; i <= n - m; i++) {
        if (patHash == strHash) {
            if (s.substring(i, i + m).equals(pat)) {
                System.out.println("Pattern found at index " + i);
            }
        }
        if (i < n - m) {
            strHash = updateHash(strHash, s.charAt(i), s.charAt(i + m), m);
        }
    }
}
```

- `s`: The text string.
- `pat`: The pattern string.
- `n`: The length of the text string.
- `m`: The length of the pattern string.
- `strHash`: The rolling hash of the text.
- `patHash`: The hash of the pattern.

The function iterates over the text and uses the rolling hash to efficiently check for the pattern's presence at each position.

### Usage

The `main` function demonstrates the usage of the Karp-Rabin algorithm by searching for a pattern within a text string.

```java
public static void main(String[] args) {
    String str = "aaabbaabababaabmagvanaaaabhaaa";
    String pat = "aaa";
    KarpRabinAlgo(str, pat);
}
```

- `str`: The text string.
- `pat`: The pattern string.

The output of this example will be:
```
Pattern found at index 0
Pattern found at index 21
Pattern found at index 27
```

This means that the pattern "aaa" is found at the specified indices in the text string.

## Conclusion

The Karp-Rabin algorithm is an efficient string matching algorithm that uses hashing to find patterns within a text. This implementation demonstrates the creation and updating of hashes and the use of the Karp-Rabin algorithm to search for patterns in a string.
