# QuickSort in Java

This project implements the QuickSort algorithm in Java. QuickSort is a popular and efficient sorting algorithm that follows the divide-and-conquer paradigm. The code sorts an array of integers using the QuickSort algorithm.

## Code Explanation

### Main Class

```java
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 8, 484, 36, 3, 8, 79, 7, 5, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
```

#### Explanation
- The `QuickSort` class contains the main method, which is the entry point of the program.
- An array of integers `arr` is defined and initialized with some values.
- The `quickSort` method is called with the array `arr`, the starting index `0`, and the ending index `arr.length - 1`.
- After sorting, the array is printed using `Arrays.toString(arr)`.

### QuickSort Method

```java
    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int s = low, e = high;
        int pivot = arr[low + (high - low) / 2];
        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }
}
```

#### Explanation
- The `quickSort` method is a recursive method that sorts a portion of the array between indices `low` and `high`.
- The base case of the recursion is when `low` is greater than or equal to `high`, in which case the method returns without doing anything.
- `s` and `e` are initialized to `low` and `high`, respectively.
- The pivot element is chosen as the middle element of the array segment being sorted.
- A `while` loop runs as long as `s` is less than or equal to `e`.
    - Inside this loop, `s` is incremented while elements at `arr[s]` are less than the pivot.
    - Similarly, `e` is decremented while elements at `arr[e]` are greater than the pivot.
    - If `s` is less than or equal to `e`, the elements at `arr[s]` and `arr[e]` are swapped, and `s` and `e` are adjusted.
- After partitioning, the method recursively sorts the two subarrays:
    - From `low` to `e`.
    - From `s` to `high`.

## Summary

This implementation of QuickSort in Java demonstrates the core concepts of the algorithm:
- Choosing a pivot element.
- Partitioning the array around the pivot.
- Recursively sorting the subarrays.

By understanding and running this code, you can see how QuickSort effectively sorts an array of integers.
