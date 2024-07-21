### README for HeapSort Implementation

This document explains the `HeapSort` implementation provided, breaking down the code into manageable parts for better understanding.

#### 1. Imports and Class Definition

```java
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7,8,4,9,5,6,7,4,7,68,5,8744,7,445,4433};
        int n = arr.length;
        
        // creating heap 
        for(int i = n/2; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // sorting min heap
        heapSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
```

- **Imports**: The `java.util.Arrays` package is imported for utilizing the `Arrays.toString` method to print the array.
- **Class Definition**: The class is defined as `HeapSort`.
- **Main Method**: This is the entry point of the program. An array `arr` is initialized with a set of integers to be sorted. The length of the array `n` is stored in a variable.

#### 2. Heap Creation

```java
for(int i = n/2; i >= 0; i--) {
    heapify(arr, n, i);
}
```

- **Heap Construction**: The for loop runs from the middle of the array (`n/2`) to the beginning. This is the standard way to convert an array into a max-heap.
- **Heapify**: The `heapify` method is called to ensure the heap property is maintained for each node, starting from the last non-leaf node.

#### 3. Heap Sort

```java
heapSort(arr, n);
System.out.println(Arrays.toString(arr));
```

- **Sorting the Heap**: After the heap is constructed, `heapSort` method is called to sort the heap.
- **Print Sorted Array**: The sorted array is printed using `Arrays.toString`.

#### 4. Heap Sort Method

```java
private static void heapSort(int[] arr, int size) {
    int n = size - 1;
    while(n > 0) {
        swap(arr, 0, n);
        heapify(arr, n, 0);
        n--;
    }
}
```

- **Heap Sort Implementation**: The `heapSort` method continuously swaps the first element (largest in max-heap) with the last unsorted element, reduces the heap size, and calls `heapify` to maintain the heap property.
- **Decrement `n`**: The variable `n` is decremented to exclude the last sorted element.

#### 5. Heapify Method

```java
private static void heapify(int[] arr, int n, int i) {
    int largest = i;
    int left = 2 * i;
    int right = 2 * i + 1;
    if(left < n && arr[left] > arr[largest]) {
        largest = left;
    }
    if(right < n && arr[right] > arr[largest]) {
        largest = right;
    }
    if(largest != i) {
        swap(arr, largest, i);
        heapify(arr, n, largest);
    }
}
```

- **Heapify Function**: Ensures the subtree rooted at index `i` satisfies the max-heap property.
- **Left and Right Child Calculation**: The left and right children of node `i` are calculated using the formula `2*i` and `2*i + 1`, respectively.
- **Largest Element Determination**: Compares the node with its children to find the largest element.
- **Swap and Recursion**: If the largest element is not the root, it swaps the elements and recursively heapifies the affected subtree.

#### 6. Swap Method

```java
private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
```

- **Swap Function**: Swaps the elements at indices `i` and `j` in the array.

This breakdown should provide a clear understanding of how the `HeapSort` class works to sort an array using heap sort algorithm.
