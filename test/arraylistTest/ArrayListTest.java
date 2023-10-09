package arraylistTest;

import array_list.*;
import data_test.MarkComparator;
import data_test.NameComparator;
import data_test.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ArrayListTest {

    MyArray<String> myArray = new MyArrayList<>();

    @BeforeEach
    void fillArray() {

        myArray.add("привет");
        myArray.add("пока");
        myArray.add("как дела?");
    }

    @Test
    void sizeArrayListTest() {
        assertNotNull(myArray, "Лист пуст");
        assertEquals(3, myArray.size(), "Размер списка не соответствует количеству добавленных элементов");
    }

    @Test
    void getElementByIndexTest() {
        assertEquals("привет", myArray.get(0), "Добавленное значение не соответствует " +
                "полученному значению по индексу");
    }

    @Test
    void addElementTest() {
        myArray.add("Устала");
        assertEquals(4, myArray.size(), "Размер списка не соответствует количеству добавленных элементов");
        assertEquals("Устала", myArray.get(3), "Добавленное значение не соответствует " +
                "полученному значению по индексу");
    }

    @Test
    void addElementInIndexTest() {
        myArray.add(0, "Устала");
        assertEquals(4, myArray.size(), "Размер списка не соответствует количеству добавленных элементов");
        assertEquals("Устала", myArray.get(0), "Добавленное значение не соответствует " +
                "полученному значению по индексу");
        myArray.add(2, "Устала");
        assertEquals(5, myArray.size(), "Размер списка не соответствует количеству добавленных элементов");
        assertEquals("Устала", myArray.get(2), "Добавленное значение не соответствует " +
                "полученному значению по индексу");
        myArray.add(5, "Устала");
        assertEquals(6, myArray.size(), "Размер списка не соответствует количеству добавленных элементов");
        assertEquals("Устала", myArray.get(5), "Добавленное значение не соответствует " +
                "полученному значению по индексу");
    }

    @Test
    void lastIndexOfElementTest() {
        myArray.add(0, "Устала");
        myArray.add(2, "Устала");
        myArray.add(5, "Устала");
        assertEquals(5, myArray.lastIndexOf("Устала"), "Найденное значение не соответствует " +
                "полученному значению по индексу");
    }

    @Test
    void deleteRangeTest() {
        myArray.add(0, "Устала");
        myArray.add(2, "Устала");
        myArray.add(5, "Устала");
        myArray.deleteRange(1, 2);
        assertEquals(5, myArray.size(), "Размер листа не соответствует");
        assertFalse(myArray.contains("привет"), "указанный диапазон не удален");
    }

    @Test
    void deleteRangeTestFromZeroIndexToArraySizeIndex() {
        myArray.deleteRange(0, 2);
        assertEquals(1, myArray.size(), "Размер листа не соответствует");
    }

    @Test
    void containsElementTest() {
        assertTrue(myArray.contains("привет"), "Запрашиваемого элемента нет в листе");
        assertFalse(myArray.contains("спасибо"), "Значение, которое не должно быть в листе, обнаружено");
    }

    @Test
    void setNewValueInPositionIndexTest() {
        myArray.set(0, "Update");
        assertEquals(3, myArray.size(), "Размер списка не соответствует количеству добавленных элементов");
        assertEquals("Update", myArray.get(0), "Значение не обновлено");
    }

    @Test
    void indexOfElementTest() {
        assertEquals(0, myArray.indexOf("привет"), "Найден неверный индекс");
        assertEquals(2, myArray.indexOf("как дела?"), "Найден неверный индекс");
        assertEquals(-1, myArray.indexOf("я"), "Найден неверный индекс, в случае отсутствия запрашиваемого элемента");
    }

    @Test
    void clearArrayListTest() {
        myArray.clear();
        assertEquals(0, myArray.size(), "Список не очищен");
    }

    @Test
    void removeElementByIndexTest() {
        myArray.delete(1);
        assertEquals(2, myArray.size(), "Размер списка не соответствует количеству " +
                "элементов после удаления");
        assertEquals("как дела?", myArray.get(1), "Значение не удалено");
    }

    @Test
    void removeByElementValueTest() {
        myArray.delete("пока");
        assertEquals(2, myArray.size(), "Размер списка не соответствует количеству " +
                "элементов после удаления");
        assertFalse(myArray.contains("пока"), "Значение не удалено");
    }

    @Test
    void quickSortArrayTest() {
        myArray.add("A");
        myArray.add("Б");
        myArray.add("В");
        assertEquals(6, myArray.size(), "Размер списка не соответствует количеству " +
                "элементов после удаления");
        MyArray<String> testArray = new MyArrayList<>();
        QuickSort.quickSort(myArray);
        testArray.add("A");
        testArray.add("Б");
        testArray.add("В");
        testArray.add("как дела?");
        testArray.add("пока");
        testArray.add("привет");
        assertEquals(myArray, testArray, "Сортировка выполнена неверно");
    }
    @Test
    void arrayTestSort() {
        myArray.add("A");
        myArray.add("Б");
        myArray.add("В");
        assertEquals(6, myArray.size(), "Размеры списков не равны");
        MyArray<String> testArray = new MyArrayList<>();
        myArray.sort();
        testArray.add("A");
        testArray.add("Б");
        testArray.add("В");
        testArray.add("как дела?");
        testArray.add("пока");
        testArray.add("привет");
        assertEquals(myArray, testArray, "Сортировка выполнена неверно");
    }

    @Test
    void arrayTestSortObjectsByDoubleField() {
        MyArray<Student> needToSortArray = new MyArrayList<>();
        Student st1 = new Student(100, "Kira", "Petrova",6.5);
        Student st2 = new Student(15, "Ivan", "Zimin",8.3);
        Student st3 = new Student(123, "Petr", "Minin",7.4);
        Student st4 = new Student(15, "Mariya", "Miller",8.8);
        needToSortArray.add(st1);
        needToSortArray.add(st2);
        needToSortArray.add(st3);
        needToSortArray.add(st4);
        QuickSort.quickSort(needToSortArray, new MarkComparator());
        MyArray<Student> testArray = new MyArrayList<>();
        testArray.add(st1);
        testArray.add(st3);
        testArray.add(st2);
        testArray.add(st4);
        assertEquals(needToSortArray, testArray, "Сортировка выполнена неверно");
    }

    @Test
    void arrayTestSortObjectsByStringField() {
        MyArray<Student> needToSortArray = new MyArrayList<>();
        Student st1 = new Student(100, "Kira", "Petrova",6.5);
        Student st2 = new Student(15, "Ivan", "Zimin",8.3);
        Student st3 = new Student(123, "Petr", "Minin",7.4);
        Student st4 = new Student(15, "Mariya", "Miller",8.8);
        needToSortArray.add(st1);
        needToSortArray.add(st2);
        needToSortArray.add(st3);
        needToSortArray.add(st4);
        QuickSort.quickSort(needToSortArray, new NameComparator());
        MyArray<Student> testArray = new MyArrayList<>();
        testArray.add(st2);
        testArray.add(st1);
        testArray.add(st4);
        testArray.add(st3);
        assertEquals(needToSortArray, testArray, "Сортировка выполнена неверно");
    }
}