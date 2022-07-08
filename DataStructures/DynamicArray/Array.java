package DataStructures.DynamicArray;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Array<T> implements Iterable<T> {
    // Array Implementation
    private T[] arr;
    private int len; // Length user thinks for the array
    private int capacity; // Actual array size

    // Default Constructor
    public Array() {
        this.capacity = 16;
    }

    //

    // Parameterized Constructor
    public Array(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Incorrect capacity: " + capacity);
        }
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    // Method to retrieve array size
    public int size() {
        return len;
    }

    // Method to check if array is empty or not
    public boolean isEmpty() {
        return size() == 0;
    }

    // Method to get an element from array
    public T get(int index) {
        return arr[index];
    }

    // Method to set an element on a particular index
    public void set(int index, T elem) {
        arr[index] = elem;
    }

    // Method to clear an array
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    // Method to add an element to an array
    public void add(T elem) {
        // Check if the length has exceeded the capacity
        if ((len + 1) >= capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity = 2 * capacity; // Double the capacity
            }
            T[] newArr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[len++] = elem;
    }

    // Method to remove an element on an specified index from an array
    public T removeAt(int rm_index) {
        // Check index is valid or not
        if (rm_index >= len && rm_index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T data = arr[rm_index];
        T[] newArr = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (i == rm_index) {
                j--; // Skip over rm_index by fixing j temporarity
            } else {
                newArr[j] = arr[i];
            }
        }
        arr = newArr;
        capacity = --len;
        return data;
    }

    // Method to remove specified object from an array
    public boolean remove(Object obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    // Method to return index of an array element
    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    // Method to check if an element exists in an array or not
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < len;
            }

            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) {
                sb.append(arr[i] + ", ");
            }
            return sb.append(arr[len - 1] + "]").toString();
        }
    }
}