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

        int[] arr6 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortByQuickSort(arr6);
        System.out.println("-Quick Sort-");
        for (int num : arr6) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
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
            swap(arr, i, min);
        }
    }

    // 삽입 정렬(Insertion Sort) -> worst & average = O(n^2), best(이미 정렬됨) = O(n)
    public static void sortByInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 버블 정렬(Bubble Sort) -> worst & average & best = O(n^2)
    public static void sortByBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 합병(병합) 정렬(Merge Sort) -> worst & average & best = O(nlog n)
    public static void sortByMergeSort(int[] arr) {
        int[] tmpArr = new int[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int[] tmpArr, int left, int right) {
        if (left < right) {
            int m = left + (right - left) / 2;
            mergeSort(arr, tmpArr, left, m);
            mergeSort(arr, tmpArr, m + 1, right);
            merge(arr, tmpArr, left, m, right);
        }
    }

    public static void merge(int[] arr, int[] tmpArr, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tmpArr[i] = arr[i];
        }
        int part1 = left;
        int part2 = mid + 1;
        int index = left;
        while (part1 <= mid && part2 <= right) {
            if (tmpArr[part1] <= tmpArr[part2]) {
                arr[index] = tmpArr[part1];
                part1++;
            } else {
                arr[index] = tmpArr[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmpArr[part1 + i];
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

    // 퀵 정렬(Quick Sort) -> average & best = O(nlog n), worst = O(n^2)
    public static void sortByQuickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        int part = partition(arr, left, right);
        if (left < part - 1) {
            quickSort(arr, left, part - 1);
        }
        if (part < right) {
            quickSort(arr, part, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
}
