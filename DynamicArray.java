import java.util.Arrays;
import java.util.NoSuchElementException;

public class DynamicArray<T> {
    private T[] arr;
    private int size;

    public DynamicArray() {
        this.size = 0;
        this.arr = (T[]) new Object[5];
    }

    public DynamicArray(T[] arr) {
        this.size = arr.length;
        this.arr = (T[]) new Object[size * 2];
        System.arraycopy(arr, 0, this.arr, 0, size);
    }

    public void add(T value) {
        arr[size++] = value;
    }

    public String toString() {
        return Arrays.toString(arr);
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
        arr[size] = null;
    }

    public void removeAll(T item) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                remove(i--);
            }
        }
    }

    public T getMin() {
        if (size == 0) {
            throw new NoSuchElementException("Array is empty");
        }
        T min = arr[0];
        for (int i = 1; i < size; i++) {
            if (((Comparable<T>) arr[i]).compareTo(min) < 0) {
                min = arr[i];
            }
        }
        return min;
    }

    public T getMax() {
        if (size == 0) {
            throw new NoSuchElementException("Array is empty");
        }
        T max = arr[0];
        for (int i = 1; i < size; i++) {
            if (((Comparable<T>) arr[i]).compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public int getSum() {
        int result = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] instanceof Number) {
                result += ((Number) arr[i]).doubleValue();
            } else {
                throw new IllegalArgumentException("Array contains non-numeric element!");
            }
        }
        return result;
    }

    public int getProduct() {
        int result = 1;
        for (int i = 0; i < size; i++) {
            if (arr[i] instanceof Number) {
                result *= ((Number) arr[i]).doubleValue();
            } else {
                throw new IllegalArgumentException("Array contains non-numeric element!");
            }
        }
        return result;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) arr[j]).compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void insertionSort() {
        for (int i = 1; i < size; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && ((Comparable<T>) arr[j]).compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (((Comparable<T>) arr[j]).compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    public void set(int index, T value) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = value;
    }
    
    public int size() {
        return this.size;
    }
}