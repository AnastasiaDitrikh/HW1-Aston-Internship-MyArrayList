package array_list;


public interface MyArray<E> {
    boolean add(E e);

    void add(int index, E e);

    int indexOf(E e);

    int lastIndexOf(E e);

    void delete(int index);


    void deleteRange(int indexStart, int indexEnd);

    void delete(E e);

    E get(int index);

    int size();

    boolean contains(E e);

    void clear();


    E set(int index, E e);

    void sort();
}