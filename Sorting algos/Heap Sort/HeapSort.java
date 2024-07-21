import java.util.Arrays;

public class HeapSort{
    public static void main(String [] args) {
        int[] arr = {7,8,4,9,5,6,7,4,7,68,5,8744,7,445,4433};
        int n = arr.length;
        
        // creating heap 
        for(int i = n/2;i >= 0;i --) {
            heapify(arr,n,i);
        }
        //sorting min heap
        heapSort(arr,n);
        System.out.println(Arrays.toString(arr));
    }
    private static void heapSort(int[] arr,int size) {
        int n = size - 1;
        while(n > 0) {
            swap(arr,0,n);
            heapify (arr,n,0);
            n--;
        }
    }
    private static void heapify(int[] arr,int n,int i) {
        int largest = i;
        int left = 2*i;
        int right = 2*i+1;
        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if(largest != i) {
            swap(arr,largest,i);
            heapify(arr,n,largest)
        }
    }
    private static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  }
