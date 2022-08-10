package classes;

import java.util.Arrays;

public class ArrayList<T> {
    private final int START_SIZE = 10;
    private int size;
    private int nextPosition;
    private T[] arr;

    public ArrayList() {
        arr = (T[]) new Object[START_SIZE];
        size = START_SIZE;
        nextPosition = 0;
    }

    private void extend() {
        size *= 2;
        arr = Arrays.copyOf(arr, size);
    }
    private void pushRight(int fromPosition) {
        for (int i = nextPosition; i > fromPosition; i--) {
            arr[i] = arr[i - 1];
        };
        nextPosition++;
    }
    private void pushLeft(int toPosition) {
        nextPosition--;
        for (int i = toPosition; i < nextPosition; i++) {
            arr[i] = arr[i + 1];
        };
    }

    public void add(T e) {
        if (nextPosition < size) {
            arr[nextPosition] = e;
            nextPosition++;
        } else {
            extend();
            add(e);
        };
    }
    public void add(int position, T e) {
        if (position > nextPosition) {
            throw new IndexOutOfBoundsException();
        }
        if (!(nextPosition < size - 1)) {
            extend();
        }
        pushRight(position);
        arr[position] = e;
    }
    public void set(int position, T e) {
        if (position < nextPosition) {
            arr[position] = e;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    public void remove(int position) {
        if (position < nextPosition) {
            pushLeft(position);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    public T get(int position) {
        return arr[position];
    }
    public int indexOf(T e) {
        for (int i = 0; i < nextPosition; i++) {
            if (e.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }
    public int size() {
        return nextPosition;
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < nextPosition; i++) {
            str += arr[i] + ", ";
        }
        str = str.length() == 1 ? str : str.substring(0, str.length() - 2) + "]";
        return str;
    }
}
