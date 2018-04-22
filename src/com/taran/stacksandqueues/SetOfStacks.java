package com.taran.stacksandqueues;

import java.util.ArrayList;

public class SetOfStacks {
    private ArrayList<Stack<Integer>> setOfStacks = new ArrayList<>();
    private int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
        Stack<Integer> newStack = new Stack<>(capacity);
        setOfStacks.add(newStack);
    }

    public void push(int item) {
        Stack<Integer> lastStack = getLastStack();
        lastStack.push(item);
        if(lastStack.isFull()) {
            Stack<Integer> newStack = new Stack<>(capacity);
            setOfStacks.add(newStack);
        }
    }

    public Integer pop() {
        Stack<Integer> lastStack = getLastStack();
        int item = lastStack.pop();
        if(lastStack.isEmpty()) {
            setOfStacks.remove(lastStack);
        }
        return item;
    }

    public Integer peek() {
        Stack<Integer> lastStack = getLastStack();
        return lastStack.peek();
    }

    private Stack<Integer> getLastStack() {
        return setOfStacks.get(setOfStacks.size() - 1);
    }

    public static void main(String[] args) {
        SetOfStacks set = new SetOfStacks(4);
        set.push(5);
        set.push(12);
        set.push(53);
        set.push(26);
        set.push(65);
        set.push(23);
        set.push(87);

        System.out.println(set.pop());
        System.out.println(set.pop());
        System.out.println(set.pop());
        System.out.println(set.pop());
        System.out.println(set.pop());

    }
}
