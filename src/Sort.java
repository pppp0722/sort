public class Sort {

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
    }

    // 선택 정렬 -> O(n^2)
    public static void sortBySelectionSort(int[] arr) {
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
    }

    // 삽입 정렬 -> O(n^2)
    public static void sortByInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    // 버블 정렬 -> O(n^2)
    public static void sortByBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    // 합병(병합) 정렬 -> O(nlog n)
    public static void sortByMergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int[] tmp, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, tmp, l, m);
            mergeSort(arr, tmp, m + 1, r);
            merge(arr, tmp, l, m, r);
        }
    }

    public static void merge(int[] arr, int[] tmp, int l, int m, int r) {
        for (int i = l; i <= r; i++) {
            tmp[i] = arr[i];
        }
        int part1 = l;
        int part2 = m + 1;
        int index = l;
        while (part1 <= m && part2 <= r) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= m - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
    }
}
