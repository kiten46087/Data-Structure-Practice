package StackAndQueue;

/**
 * This question uses a array to represent three stacks.
 * The below implementation is using the fixed length array to represent the three stack. 
 * 
 * Another implementation is using the circular array to represent and is far more complex. 
 * So I just skipped that.
 */
public class ThreeInOne {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeInOne(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }


    /* Return if stack is empty.*/
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }


    /* Return if stack is full. */
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }


    /* Return index of the top of the stack. */
    public int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    /* Push value onto stack. */
    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            System.out.println("This stack is already full");
            return;
        }

        /* Update the stack at the stackNum. */
        sizes[stackNum] += 1;
        values[indexOfTop(stackNum)] = value;
    }

    /* Pop item from top stack. */
    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("The stack is already empty!");
            return 0;
        }

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex]; 
        values[topIndex] = 0;
        sizes[stackNum] -= 1;

        return value;
    }

    /* Return item from top of the stack. */
    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("The stack is already empty!");
            return 0;
        }
        return values[indexOfTop(stackNum)];
    }
}