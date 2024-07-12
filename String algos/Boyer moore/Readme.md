
```markdown
# Boyer-Moore Majority Vote Algorithm Implementation

This repository contains an implementation of the Boyer-Moore Majority Vote algorithm in Java. The algorithm is used to find the majority element in a given string, where the majority element is the element that appears more than half the time.

## Table of Contents

- [Introduction](#introduction)
- [Code Explanation](#code-explanation)
  - [Finding the Majority Element](#finding-the-majority-element)
- [Usage](#usage)
- [Conclusion](#conclusion)

## Introduction

The Boyer-Moore Majority Vote algorithm is an efficient algorithm to find the majority element in a sequence. It operates in linear time O(n) and uses constant space O(1). The algorithm works by maintaining a count of a candidate for the majority element and adjusting this count as it iterates through the sequence.

## Code Explanation

### Finding the Majority Element

The `findMajorityElem` function finds the majority element in the given string.

```java
public static void findMajorityElem(String s) {
    int n = s.length();
    int cnt = 1;
    char maj = s.charAt(0);
    for (int i = 1; i < n; i ++) {
        if (cnt == 0) {
            maj = s.charAt(i);
            cnt = 1;
        }
        if (s.charAt(i) == maj) {
            cnt ++;
        } else {
            cnt --;
        }
    }
    System.out.println("Majority elem is " + maj);
}
```

- `s`: The input string.
- `n`: The length of the input string.
- `cnt`: A counter for the candidate majority element.
- `maj`: The current candidate for the majority element.

The function iterates over the string and adjusts the `cnt` based on whether the current character matches the candidate `maj`. If `cnt` drops to zero, the next character becomes the new candidate.

### Usage

The `main` function demonstrates the usage of the Boyer-Moore Majority Vote algorithm by finding the majority element in a given string.

```java
public static void main(String[] args) {
    String str = "aaabbaabababaabmagvanaaaabhbbb";
    findMajorityElem(str);
}
```

- `str`: The input string.

The output of this example will be:
```
Majority elem is a
```

This means that the character 'a' appears more than half the time in the string "aaabbaabababaabmagvanaaaabhbbb".

## Conclusion

The Boyer-Moore Majority Vote algorithm is an efficient algorithm for finding the majority element in a sequence. This implementation demonstrates how to use the algorithm to find the majority element in a given string.
