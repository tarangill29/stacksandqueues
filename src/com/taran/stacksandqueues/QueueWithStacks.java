package com.taran.stacksandqueues;

public class QueueWithStacks {
    Stack<Integer> newest = new Stack<>();
    Stack<Integer> oldest = new Stack<>();

    public void add(int item) {
        newest.push(item);
    }

    public int remove() {
        shiftStacks();
        return oldest.pop();
    }

    public int peek() {
        shiftStacks();
        return oldest.peek();
    }

    private void shiftStacks() {
        if(oldest.isEmpty()) {
            while (!newest.isEmpty()) {
                oldest.push(newest.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueWithStacks qs = new QueueWithStacks();
        qs.add(34);
        qs.add(45);
        qs.add(1);
        qs.add(7);
        qs.add(12);
        qs.add(90);
        System.out.println(qs.peek());
        System.out.println(qs.remove());
        System.out.println(qs.remove());
        System.out.println(qs.peek());
        System.out.println(qs.remove());
        System.out.println(qs.remove());
        System.out.println(qs.remove());
        System.out.println(qs.remove());
        qs.add(123);
        qs.add(77);
        qs.add(11);
        System.out.println(qs.remove());

        System.out.println(qs.peek());


    }
}
