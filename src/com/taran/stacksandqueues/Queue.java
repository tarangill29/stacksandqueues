package com.taran.stacksandqueues;

import java.util.NoSuchElementException;

public class Queue<T> {

    private static class QueueNode<T> {
        T data;
        QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public boolean isEmpty() {
        return first == null;
    }

    public void add(T item) {
        QueueNode<T> node = new QueueNode<>(item);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
        if (first.next == null) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        return data;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }
    public static void main(String[] args) {
        Queue<Integer> stack = new Queue<>();
        stack.add(23);
        stack.add(44);
        stack.add(67);
        stack.remove();
        System.out.println(stack.peek());
        System.out.println(stack.remove());
        System.out.println(stack.remove());

    }

}
