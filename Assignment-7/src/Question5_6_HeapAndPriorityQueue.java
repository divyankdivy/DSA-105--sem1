/**
 * Questions 5 & 6: Heap Fundamentals
 * Question 5: Implement Heapsort (Increasing & Decreasing order)
 * Question 6: Implement Priority Queue using Heaps
 */
import java.util.Arrays;

public class Question5_6_HeapAndPriorityQueue {

    // ====================================================
    // QUESTION 5: HEAPSORT (Increasing & Decreasing Order)
    // ====================================================

    // --- Increasing Order (Ascending) using Max-Heap ---
    public static void heapSortAscending(int[] arr) {
        int n = arr.length;

        // Step 1: Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }

        // Step 2: Extract elements one by one from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxHeapify(arr, i, 0);
        }
    }

    private static void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            maxHeapify(arr, n, largest);
        }
    }

    // --- Decreasing Order (Descending) using Min-Heap ---
    public static void heapSortDescending(int[] arr) {
        int n = arr.length;

        // Step 1: Build min heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(arr, n, i);
        }

        // Step 2: Extract elements one by one from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            minHeapify(arr, i, 0);
        }
    }

    private static void minHeapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest]) smallest = left;
        if (right < n && arr[right] < arr[smallest]) smallest = right;

        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            minHeapify(arr, n, smallest);
        }
    }

    // ====================================================
    // QUESTION 6: PRIORITY QUEUE USING HEAP
    // ====================================================

    static class PriorityQueue {
        private int[] heap;
        private int capacity;
        private int size;

        public PriorityQueue(int cap) {
            capacity = cap;
            heap = new int[capacity];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public int peek() {
            if (isEmpty()) throw new IllegalStateException("Priority Queue is empty!");
            return heap[0];
        }

        // Insert element into Priority Queue
        public void insert(int val) {
            if (size == capacity) {
                capacity *= 2;
                heap = Arrays.copyOf(heap, capacity);
            }
            heap[size] = val;
            int curr = size;
            size++;

            // Heapify-up to maintain Max-Heap property
            while (curr > 0 && heap[curr] > heap[(curr - 1) / 2]) {
                int parent = (curr - 1) / 2;
                int temp = heap[curr];
                heap[curr] = heap[parent];
                heap[parent] = temp;
                curr = parent;
            }
        }

        // Extract maximum element (highest priority)
        public int extractMax() {
            if (isEmpty()) throw new IllegalStateException("Priority Queue is empty!");
            int maxVal = heap[0];
            heap[0] = heap[size - 1];
            size--;

            // Heapify-down
            maxHeapifyDown(0);
            return maxVal;
        }

        private void maxHeapifyDown(int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < size && heap[left] > heap[largest]) largest = left;
            if (right < size && heap[right] > heap[largest]) largest = right;

            if (largest != i) {
                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;
                maxHeapifyDown(largest);
            }
        }
    }

    // ====================================================
    // MAIN DEMONSTRATION
    // ====================================================

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("QUESTION 5: HEAPSORT DEMONSTRATION");
        System.out.println("======================================");
        int[] arr1 = {12, 11, 13, 5, 6, 7};
        System.out.println("Original Array:        " + Arrays.toString(arr1));

        int[] arrAsc = arr1.clone();
        heapSortAscending(arrAsc);
        System.out.println("Increasing Order Sort: " + Arrays.toString(arrAsc));

        int[] arrDesc = arr1.clone();
        heapSortDescending(arrDesc);
        System.out.println("Decreasing Order Sort: " + Arrays.toString(arrDesc));

        System.out.println("\n======================================");
        System.out.println("QUESTION 6: PRIORITY QUEUE DEMONSTRATION");
        System.out.println("======================================");
        PriorityQueue pq = new PriorityQueue(10);

        System.out.println("Inserting elements: 30, 10, 50, 20, 40");
        pq.insert(30);
        pq.insert(10);
        pq.insert(50);
        pq.insert(20);
        pq.insert(40);

        System.out.println("Highest Priority Element (Peek): " + pq.peek());

        System.out.print("Extracting elements by priority (Max to Min): ");
        while (!pq.isEmpty()) {
            System.out.print(pq.extractMax() + " ");
        }
        System.out.println();
    }
}
