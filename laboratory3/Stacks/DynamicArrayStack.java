package Laboratory3.Stacks;


import java.util.EmptyStackException;

public class DynamicArrayStack<E> implements Stack<E> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArrayStack() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void push(E item) {
        ensureCapacity(size + 1);
        array[size++] = item;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E item = (E) array[--size];
        array[size] = null;
        return item;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = Math.max(array.length * 2, minCapacity);
            array = java.util.Arrays.copyOf(array, newCapacity);
        }
    }
}