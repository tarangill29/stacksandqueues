package com.taran.stacksandqueues;

import java.util.EmptyStackException;

public class Stack<T> {

    private static class StackNode<T> {
        StackNode<T> next;
        T data;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;
    private int capacity;
    private int size;

    public Stack() {
        this.capacity = 500;
    }

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    public void push(T item) {
        if(size >= capacity) throw new StackOverflowError();
        StackNode<T> node= new StackNode<>(item);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(23);
        stack.push(44);
        stack.push(67);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

}
