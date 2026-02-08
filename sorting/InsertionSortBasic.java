public class InsertionSortBasic {

    // Method to perform insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements that are greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place key at its correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int[] arr = {5, 3, 4, 1, 2};

        System.out.print("Before Sorting: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        insertionSort(arr);

        System.out.print("\nAfter Sorting:  ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}

