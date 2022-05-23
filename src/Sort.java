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

        int[] arr5 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortByHeapSort(arr5);
        System.out.println("-Heap Sort-");
        for (int num : arr5) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }

    // 선택 정렬(Selection Sort) -> worst & average & best = O(n^2)
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

    // 삽입 정렬(Insertion Sort) -> worst & average = O(n^2), best(이미 정렬됨) = O(n)
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

    // 버블 정렬(Bubble Sort) -> worst & average & best = O(n^2)
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

    // 합병(병합) 정렬(Merge Sort) -> worst & average & best = O(nlog n)
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

    // 힙 정렬(Heap Sort) -> worst & average & best = O(nlog n)
    public static void sortByHeapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i < arr.length; i++) {
            heapify(arr, i, arr.length - 1);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static void heapify(int[] arr, int parentIdx, int lastIdx) {
        int leftChildIdx;
        int rightChildIdx;
        int largestIdx;

        while (parentIdx * 2 + 1 <= lastIdx) {
            leftChildIdx = (parentIdx * 2) + 1;
            rightChildIdx = (parentIdx * 2) + 2;
            largestIdx = parentIdx;

            if (arr[leftChildIdx] > arr[largestIdx]) {
                largestIdx = leftChildIdx;
            }

            if (rightChildIdx <= lastIdx && arr[rightChildIdx] > arr[largestIdx]) {
                largestIdx = rightChildIdx;
            }

            if (largestIdx != parentIdx) {
                swap(arr, parentIdx, largestIdx);
                parentIdx = largestIdx;
            } else {
                break;
            }
        }
    }
}
