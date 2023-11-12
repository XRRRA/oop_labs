package Laboratory3;

import Laboratory3.Queues.DynamicArrayQueue;
import Laboratory3.Queues.LinkedListQueue;
import Laboratory3.Queues.MinHeapQueue;
import Laboratory3.Queues.Queue;
import Laboratory3.Stacks.ArrayStack;
import Laboratory3.Stacks.DynamicArrayStack;
import Laboratory3.Stacks.LinkedListStack;
import Laboratory3.Stacks.Stack;

public class Tests {
    public static boolean testQueues() {
        boolean dynamicArrayTest = true;
        boolean linkedListTest = true;
        boolean minHeapTest = true;

        // Test for Dynamic Array Queue
        Queue<Integer> dynamicArrayQueue = new DynamicArrayQueue<>();
        dynamicArrayQueue.enqueue(1);
        dynamicArrayQueue.enqueue(2);
        dynamicArrayQueue.enqueue(3);
        dynamicArrayTest &= dynamicArrayQueue.size() == 3;
        dynamicArrayTest &= dynamicArrayQueue.peek() == 1;
        dynamicArrayTest &= dynamicArrayQueue.dequeue() == 1;
        dynamicArrayTest &= dynamicArrayQueue.size() == 2;
        dynamicArrayTest &= !dynamicArrayQueue.isEmpty();

        System.out.println((dynamicArrayTest) ? "Test 1 Passed" : "Test 1 Failed");

        // Test for Linked List Queue
        Queue<String> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.enqueue("Apple");
        linkedListQueue.enqueue("Banana");
        linkedListQueue.enqueue("Cherry");
        linkedListTest &= linkedListQueue.size() == 3;
        linkedListTest &= linkedListQueue.peek().equals("Apple");
        linkedListTest &= linkedListQueue.dequeue().equals("Apple");
        linkedListTest &= linkedListQueue.size() == 2;
        linkedListTest &= !linkedListQueue.isEmpty();

        System.out.println((linkedListTest) ? "Test 2 Passed" : "Test 2 Failed");

        // Test for Priority Queue (Min-Heap) Queue
        Queue<Double> priorityQueueQueue = new MinHeapQueue<>();
        priorityQueueQueue.enqueue(3.2);
        priorityQueueQueue.enqueue(1.5);
        priorityQueueQueue.enqueue(2.1);
        minHeapTest &= priorityQueueQueue.size() == 3;
        minHeapTest &= priorityQueueQueue.peek() == 1.5;
        minHeapTest &= priorityQueueQueue.dequeue() == 1.5;
        minHeapTest &= priorityQueueQueue.size() == 2;
        minHeapTest &= !priorityQueueQueue.isEmpty();

        System.out.println((minHeapTest) ? "Test 3 Passed" : "Test 3 Failed");

        return dynamicArrayTest && linkedListTest && minHeapTest;
    }

    public static boolean testStacks() {
        boolean dynamicArrayTest = true;
        boolean linkedListTest = true;
        boolean arrayTest = true;

        // Test for Array Stack
        Stack<Integer> arrayStack = new ArrayStack<>();
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayTest &= arrayStack.size() == 3;
        arrayTest &= arrayStack.peek() == 30;
        arrayTest &= arrayStack.pop() == 30;
        arrayTest &= arrayStack.size() == 2;
        arrayTest &= !arrayStack.isEmpty();

        System.out.println((arrayTest) ? "Test 4 Passed" : "Test 4 Failed");

        // Test for Linked List Stack
        Stack<String> linkedListStack = new LinkedListStack<>();
        linkedListStack.push("First");
        linkedListStack.push("Second");
        linkedListStack.push("Third");
        linkedListTest &= linkedListStack.size() == 3;
        linkedListTest &= linkedListStack.peek().equals("Third");
        linkedListTest &= linkedListStack.pop().equals("Third");
        linkedListTest &= linkedListStack.size() == 2;
        linkedListTest &= !linkedListStack.isEmpty();

        System.out.println((linkedListTest) ? "Test 5 Passed" : "Test 5 Failed");

        // Test for Dynamic Array Stack
        Stack<Character> dynamicArrayStack = new DynamicArrayStack<>();
        dynamicArrayStack.push('A');
        dynamicArrayStack.push('B');
        dynamicArrayStack.push('C');
        dynamicArrayTest &= dynamicArrayStack.size() == 3;
        dynamicArrayTest &= dynamicArrayStack.peek() == 'C';
        dynamicArrayTest &= dynamicArrayStack.pop() == 'C';
        dynamicArrayTest &= dynamicArrayStack.size() == 2;
        dynamicArrayTest &= !dynamicArrayStack.isEmpty();

        System.out.println((dynamicArrayTest) ? "Test 6 Passed" : "Test 6 Failed");

        return dynamicArrayTest && linkedListTest && arrayTest;
    }
}
