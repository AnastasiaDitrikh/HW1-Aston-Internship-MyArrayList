package array_list;


public class MyArrayList<E> implements MyArray<E> {
    private E[] values;

    public MyArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return false;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void add(int index, E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];

            if (index == 0) {
                values[index] = e;
                System.arraycopy(temp, 0, values, 1, temp.length);
            } else if (index == values.length - 1) {
                System.arraycopy(temp, 0, values, 0, temp.length);
                values[values.length - 1] = e;
            } else {
                System.arraycopy(temp, 0, values, 0, index);
                values[index] = e;
                System.arraycopy(temp, index, values, index + 1, temp.length - 2);
            }

        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < values.length; i++) {
            if (e == values[i]) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(E e) {
        for (int i = values.length-1; i >=0; i--) {
            if (e == values[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElemsAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amountElemsAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void deleteRange(int indexStart, int indexEnd) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - (indexEnd-indexStart)];
            System.arraycopy(temp, 0, values, 0, indexStart);
            System.arraycopy(temp, indexEnd, values, indexEnd-1, temp.length - (indexEnd-indexStart)-1);
            System.out.println("");
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void delete(E e) {
        try {
            E[] temp = values;
            int indexE= indexOf(e);
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, indexE);
            int amountElemsAfterIndex = temp.length - indexE - 1;
            System.arraycopy(temp, indexE + 1, values, indexE, amountElemsAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean contains(E e) {
        for (E value : values) {
            if (value == e) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        values = (E[]) new Object[0];
    }

    @Override
    public void quickSort() {

    }

    @Override
    public E set(int index, E e) {
        return values[index] = e;
    }
}