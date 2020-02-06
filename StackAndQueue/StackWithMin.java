package StackAndQueue;


import java.util.Stack;

/* This Solution is based on a wrapper class extended Stack class which includes a 
 * Minimial value.
 */

 public class StackWithMin extends Stack<NodeWithMin> {
	/**
     * I don't know what is this.......
     */
    private static final long serialVersionUID = -34116411210362799L;

    /* Can call the super class to add data to the normal stack. */
    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.isEmpty()) return Integer.MAX_VALUE;
        else return peek().min;
    }
 } 

 class NodeWithMin {
    public int value;
    public int min;
    public NodeWithMin(int v, int min) {
        value = v;
        this.min = min;
    }
 }