package StackAndQueue;

import java.util.Stack;


/* The same method as my two stack but using more concise. */
public class StackWithMin2 extends Stack<Integer> {
    /**
     *
     */
    private static final long serialVersionUID = 4091994649953101308L;
    Stack<Integer> s2;

    public StackWithMin2() {
        s2 = new Stack<Integer>();
    }

    public void push(int value) {
        if (value <= min()) {
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            s2.pop();
        }
        return value;
    }

    public int min() {
        if (s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }
}