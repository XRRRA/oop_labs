package Laboratory3.Stacks;

import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
    private final int MAX_CAPACITY_DEFAULT = 10;
    private Object[] array;
    private int size;

    public ArrayStack() {
        array = new Object[MAX_CAPACITY_DEFAULT];
        size = 0;
    }

    public ArrayStack(int capacity) {
        array = new Object[capacity];
        size = 0;
    }

    @Override
    public void push(E item) {
        if (size == array.length) {
            throw new StackOverflowError("Stack is full");
        }
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
}