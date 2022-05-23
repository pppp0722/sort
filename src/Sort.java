public class Sort {

    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        int[] selectionSortedArr = selectionSort(arr1);
        System.out.println("-Selection Sort-");
        for (int num : selectionSortedArr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 선택 정렬 -> O(n^2)
    public static int[] selectionSort(int[] arr) {
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
}
