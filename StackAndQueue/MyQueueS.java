package StackAndQueue;

import java.util.Stack;

/**
 * This class is more concise and we 
 * keep the buffer stack unchanged unless we actually need
 * to move.
 */
public class MyQueueS<T> {
    Stack<T> stackNewest, stackOldest;

    public MyQueueS() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T pop() {
        shiftStacks();
        return stackOldest.pop();
    }
}