package array_list;

import java.util.Comparator;

public class QuickSort{
    /**
     * Метод производит быструю сортировку в заданном пользователем порядке (пользователь указывает компоратор)
     * принимает MyArray в качестве аргумента и проверяет, что список не равен null и содержит более одного элемента.
     * Если это не так, то сортировка не требуется и метод завершает работу.
     * @param list представляет собой лист, который будет сортироваться
     * @param comparator представляет собой класс, реализованный пользователем, для указания требования сортировки
     */
    public static <E> void quickSort(MyArray<E> list, Comparator<E> comparator){
        if (list == null || list.size() <= 1) {
            return;
        }
        quickSortHelper(list, 0, list.size() - 1, comparator);
    }
    /**
     * Метод производит быструю сортировку в естественном порядке (цифры по возрастанию, строки в алфавитном порядке)
     * принимает MyArray в качестве аргумента и проверяет, что список не равен null и содержит более одного элемента.
     * Если это не так, то сортировка не требуется и метод завершает работу.
     * @param list представляет собой лист, который будет сортироваться
     */
    public static <E extends Comparable<E>> void quickSort(MyArray<E> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        Comparator<E> comparator = Comparator.naturalOrder();
        quickSortHelper(list, 0, list.size() - 1, comparator);
    }
    /**
     * Вспомогательный метод, который принимает список, начальный и конечный индексы. В нем используется рекурсивный подход
     * для разделения и сортировки списка.
     * @param list представляет собой лист, который будет сортироваться
     * @param indexStart начальный индекс
     * @param indexEnd конечный индекс
     * @param comparator представляет собой класс, реализованный пользователем, для указания требования сортировки
     */
    private static <E> void quickSortHelper(MyArray<E> list, int indexStart, int indexEnd, Comparator<E> comparator) {
        if (indexStart < indexEnd) {
            int pivotIndex = partition(list, indexStart, indexEnd, comparator);
            quickSortHelper(list, indexStart, pivotIndex - 1, comparator);
            quickSortHelper(list, pivotIndex + 1, indexEnd, comparator);
        }
    }
    /**
     * Метод выполняет разделение списка на две части относительно опорного элемента (pivot).
     * Он выбирает опорный элемент (pivot) в качестве последнего элемента списка. Затем он проходит по списку,
     * обменивая элементы местами, если они меньше или равны опорному элементу.
     * В конце он помещает опорный элемент на свое окончательное место и возвращает индекс этого элемента.
     * @param list представляет собой лист, который будет сортируется
     * @param indexStart начальный индекс
     * @param indexEnd конечный индекс
     * @param comparator представляет собой класс, реализованный пользователем, для указания требования сортировки
     * @return возвращает индекс опорного элемента, когда он становится на свое окончательное место
     */
    private static <E> int partition(MyArray<E> list, int indexStart, int indexEnd, Comparator<E> comparator) {
        E pivot = list.get(indexEnd);
        int i = indexStart - 1;
        for (int j = indexStart; j < indexEnd; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, indexEnd);
        return i + 1;
    }
    /**
     * Выполняет обмен элементами списка между двумя заданными индексами
     * @param list представляет собой лист, который сортируется
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     */
    private static <E> void swap(MyArray<E> list, int i, int j)  {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}