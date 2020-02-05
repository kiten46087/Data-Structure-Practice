package StackAndQueue;

import java.util.EmptyStackException;

/**
 * Implement the stack using connected node rather than Array
 */
public class MyStack<T> {   
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    /**
     * Pop the data from the top of the stack.
     */
    public T pop() {
        if (top == null) throw new EmptyStackException();

        T item = top.data;
        top = top.next;

        return item;
    }


    /**
     * Push the data to the top of the stack.
     */
    public void push(T data) {
        StackNode<T> newTop = new StackNode<>(data);

        newTop.next = top;
        top = newTop;
    }


    /**
     * Peek the top element of the node without 
     * removing the element.
     */
    public T peek() {
        if (top == null) throw new EmptyStackException();

        return top.data;
    }


    /**
     * Return whether the stack is empty or not.
     */
    public boolean isEmpty() {
        return top == null;
    }
}