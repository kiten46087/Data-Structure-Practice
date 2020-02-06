package StackAndQueue;

import java.util.Stack;

/*
 * This solution uses two stack one is for storing only the min value. 
 * And the other is for store normal value.
 * For max stack the answer should be the same.
 */
public class MinStack {
    Stack<Integer> min = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int minValue = Integer.MAX_VALUE;

    /* Push the value to the minStack and push the min value to the min stack at the same time. */
    public void push(int val) {
        if (minStack.isEmpty()) {
            minValue = val;    
        } else if (val < minValue) {
            minValue = val;
        }

        minStack.push(val);
        min.push(minValue);
    }


    /* Return and remove the value at the top. */
    public int pop() {
        if (minStack.isEmpty()) {
            return -1;
        }
        min.pop();
        if (!min.isEmpty()) {
            minValue = min.peek();    
        }
        
            
        return minStack.pop();
    }


    /* Get the minimal value of the currently stack. */
    public int getMin() {
        return min.peek();
    }


    /* Return the top element of the min stack. */
    public int peek() {
        return minStack.peek();
    }

    /* Return if the stack is empty. */
    public boolean isEmpty() {
        return minStack.isEmpty();
    }
}