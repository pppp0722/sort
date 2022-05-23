import static sort.Sort.*;

public class Main {

    public static void main(String[] args) {

        int[] arr1 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortBySelectionSort(arr1);
        System.out.println("-Selection Sort-");
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        int[] arr2 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortByInsertionSort(arr2);
        System.out.println("-Insertion Sort-");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        int[] arr3 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortByBubbleSort(arr3);
        System.out.println("-Bubble Sort-");
        for (int num : arr3) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        int[] arr4 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortByMergeSort(arr4);
        System.out.println("-Merge Sort-");
        for (int num : arr4) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        int[] arr5 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortByHeapSort(arr5);
        System.out.println("-Heap Sort-");
        for (int num : arr5) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        int[] arr6 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortByQuickSort(arr6);
        System.out.println("-Quick Sort-");
        for (int num : arr6) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }
}
