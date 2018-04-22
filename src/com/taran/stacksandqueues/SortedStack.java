package com.taran.stacksandqueues;

public class SortedStack {

    private Stack<Integer> primary = new Stack<>();
    private Stack<Integer> secondary = new Stack<>();

    public void push(int item) {
        if (primary.isEmpty() || item <= primary.peek()) {
            primary.push(item);
        } else {
            while (!primary.isEmpty() && item > primary.peek()) {
                secondary.push(primary.pop());
            }
            primary.push(item);
            while (!secondary.isEmpty()) {
                primary.push(secondary.pop());
            }
        }
    }

    public int pop() {
        return primary.pop();
    }

    public int peek() {
        return primary.peek();
    }

    public static void main(String[] args) {
        SortedStack s = new SortedStack();
        s.push(34);
        s.push(22);
        s.push(12);
        s.push(123);
        s.push(123);
        s.push(427);
        s.push(7);
        s.push(67);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}
