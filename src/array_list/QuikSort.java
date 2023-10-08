package array_list;

public class QuikSort {

    public static <T extends Comparable<T>> void quickSort(MyArray<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        quickSortHelper(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void quickSortHelper(MyArray<T> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSortHelper(list, low, pivotIndex - 1);
            quickSortHelper(list, pivotIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(MyArray<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(MyArray<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}