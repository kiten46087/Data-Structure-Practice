package StackAndQueue;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;


    /**
     * Add data to the end of the queue.
     */
    public void add(T data) {
        QueueNode<T> newEnd = new QueueNode<T>(data);

        if (last != null) {
            last.next = newEnd;
        }

        last = newEnd;

        if (first == null) {
            first = last;
        }
    }


    /**
     * Remove data at the head of the queue.
     */
    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return data;
    }


    /**
     * Return the data at the begining of the Queue without removing the node.
     */
    public T peek() {
        if (first == null) throw new NoSuchElementException();

        return first.data;
    }


    /**
     * Return whether the queue is empty or not.
     */
    public boolean isEmpty() {
        return first == null;
    }
}