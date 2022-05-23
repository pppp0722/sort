public class Sort {

    public static void main(String[] args) {
        Sort sort = new Sort();

        int[] arr1 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] selectionSortedArr = sort.sortBySelectionSort(arr1);
        System.out.println("-Selection Sort-");
        for (int num : selectionSortedArr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        int[] arr2 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] insertionSortedArr = sort.sortByInsertionSort(arr2);
        System.out.println("-Insertion Sort-");
        for (int num : insertionSortedArr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        int[] arr3 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] bubbleSortedArr = sort.sortByBubbleSort(arr3);
        System.out.println("-Bubble Sort-");
        for (int num : bubbleSortedArr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }

    // 선택 정렬 -> O(n^2)
    public int[] sortBySelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }

    // 삽입 정렬 -> O(n^2)
    public int[] sortByInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    // 버블 정렬 -> O(n^2)
    public int[] sortByBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
