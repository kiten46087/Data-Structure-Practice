package StackAndQueue;

import java.util.Stack;

public class SortStack {
    /**
     * This approach uses two addditional stacks. Which can be optimized by using one stack.
     */
    public Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> ret = new Stack<>();

        while (!stack.isEmpty()) {
            if (ret.isEmpty()) {
                ret.push(stack.pop());
                continue;
            }

            int tempValue = stack.pop();
            if (tempValue > ret.peek()) {
                ret.push(tempValue);
                continue;
            } 

            Stack<Integer> buffer = new Stack<>();
            while (!ret.isEmpty() && tempValue <= ret.peek()) {
                buffer.add(ret.pop());
            }

            ret.push(tempValue);

            while (!buffer.isEmpty()) {
                ret.push(buffer.pop());
            }
        }

        return ret;
    }


    /**
     * This approach uses one additional stack, and the time complexity
     * us O(N ^ 2). The time complexity can be more optimized if use one more stack
     * Which we can use to merge sort or quick sort.
     */
    public Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            while (!r.isEmpty() && r.peek() > temp) {
                s.push(r.pop());
            }
            r.push(temp);
        }

        /* Copy the elements from r back to s */
        while (!r.isEmpty()) {
            s.push(r.pop());
        }

        return r;
    }

    public static void main(String[] args) {
        SortStack test = new SortStack();

        Stack<Integer> testStack = new Stack<>();

        testStack.add(1);
        testStack.add(4);
        testStack.add(2);
        testStack.add(3);
        testStack.add(5);

        Stack<Integer> sortStack = test.sortStack(testStack);

        while (!sortStack.isEmpty()) {
            System.out.print(sortStack.pop());
        }
        System.out.println();
    }
} 