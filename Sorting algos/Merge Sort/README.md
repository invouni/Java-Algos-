### MergeSort.java

This program implements the Merge Sort algorithm in Java. The code is structured into two primary functions: `mergeSort` and `merge`. Below is a block-by-block explanation of the code.

#### 1. Main Method

```java
public static void main(String[] args) {
    int[] arr = {5, 4, 8, 484, 36, 3, 8, 79, 7, 5, 9};
    mergeSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
}
```

- **Description**: This is the main method that initializes an array of integers and calls the `mergeSort` function to sort it. After sorting, it prints the sorted array.
- **Key Points**:
  - Initializes an array `arr` with predefined values.
  - Calls `mergeSort` on the entire array.
  - Prints the sorted array using `Arrays.toString(arr)`.

#### 2. mergeSort Method

```java
private static void mergeSort(int[] arr, int low, int hi) {
    if (low >= hi) {
        return;
    }
    int mid = low + (hi - low) / 2;
    mergeSort(arr, low, mid);
    mergeSort(arr, mid + 1, hi);
    merge(low, mid, hi, arr);
}
```

- **Description**: This method recursively divides the array into smaller subarrays until each subarray contains a single element. Then, it merges the subarrays in sorted order.
- **Key Points**:
  - **Base Case**: If `low` is greater than or equal to `hi`, the function returns, meaning the subarray has one or no elements.
  - **Recursive Case**:
    - Calculate the middle index `mid`.
    - Recursively call `mergeSort` on the left subarray (`low` to `mid`).
    - Recursively call `mergeSort` on the right subarray (`mid + 1` to `hi`).
    - Merge the two sorted subarrays by calling the `merge` function.

#### 3. merge Method

```java
private static void merge(int low, int mid, int high, int[] arr) {
    int[] left = Arrays.copyOfRange(arr, low, mid + 1);
    int[] right = Arrays.copyOfRange(arr, mid + 1, high + 1);
    
    int i = 0, j = 0, k = low;
    
    while (i < left.length && j < right.length) {
        if (left[i] <= right[j]) {
            arr[k] = left[i];
            i++;
        } else {
            arr[k] = right[j];
            j++;
        }
        k++;
    }
    
    while (i < left.length) {
        arr[k] = left[i];
        i++;
        k++;
    }
    
    while (j < right.length) {
        arr[k] = right[j];
        j++;
        k++;
    }
}
```

- **Description**: This method merges two sorted subarrays (`left` and `right`) back into the original array `arr`.
- **Key Points**:
  - **Copy Subarrays**:
    - `left` subarray is created by copying elements from `arr[low]` to `arr[mid]`.
    - `right` subarray is created by copying elements from `arr[mid + 1]` to `arr[high]`.
  - **Merge Process**:
    - Initialize three indices: `i` for `left`, `j` for `right`, and `k` for the position in the original array `arr`.
    - Use a while loop to compare elements from `left` and `right` and place the smaller element into `arr`.
    - If there are remaining elements in `left`, copy them to `arr`.
    - If there are remaining elements in `right`, copy them to `arr`.
