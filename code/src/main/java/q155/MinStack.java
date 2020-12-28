package q155;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minValues;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<>();
        minValues = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (minValues.isEmpty()) {
            minValues.push(x);
        } else {
            if (x <= minValues.peek()) {
                minValues.push(x);
            }
        }
    }

    public void pop() {
        Integer pop = data.pop();
        if (getMin() == pop) {
            minValues.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minValues.peek();
    }
}