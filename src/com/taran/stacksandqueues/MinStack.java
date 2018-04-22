package com.taran.stacksandqueues;

public class MinStack extends Stack<Integer> {

    private int min;

    private Stack<Integer> minStack = new Stack<>();

    @Override
    public Integer peek() {
        return super.peek();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public void push(Integer item) {
        if(isEmpty()) {
            minStack.push(item);
        } else {
            if(minStack.peek() > item) {
                minStack.push(item);
            }
        }
        super.push(item);
    }

    @Override
    public Integer pop() {
        if (minStack.peek() == this.peek()) {
            minStack.pop();
        }
        return super.pop();
    }

    public Integer min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(17);
        ms.push(7);
        ms.push(4);
        ms.push(41);
        ms.push(0);
        ms.push(1);
        System.out.println(ms.min());
        ms.pop();
        ms.pop();
        ms.pop();
        ms.pop();
        ms.pop();
        ms.pop();

        System.out.println(ms.min());
    }
}
