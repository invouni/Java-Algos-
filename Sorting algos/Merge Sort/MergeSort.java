import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 8, 484, 36, 3, 8, 79, 7, 5, 9};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    private static void mergeSort(int[] arr, int low, int hi) {
        if (low >= hi) {
            return;
        }
        int mid = low + (hi - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, hi);
        merge(low, mid, hi, arr);
    }
    
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
  }
