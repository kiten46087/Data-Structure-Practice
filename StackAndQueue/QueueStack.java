package StackAndQueue;

import java.util.Stack;

public class QueueStack {
    /* This is the data structure acutually store the data. */
    private Stack<Integer> stack;
    private Stack<Integer> buffer;
    
    public QueueStack() {
        stack = new Stack<>();
        buffer = new Stack<>();
    }

    public void add(int data) {
        stack.push(data);
    }

    public int remove() {
        

        while (!stack.isEmpty()) {
            buffer.push(stack.pop());
        }

        int ret = buffer.pop();

        while (!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }

        return ret;
    }

    public static void main(String[] args) {
        QueueStack myQueue = new QueueStack();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);

        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
    }
}