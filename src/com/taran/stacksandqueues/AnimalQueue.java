package com.taran.stacksandqueues;

import java.util.LinkedList;

public class AnimalQueue {
    private LinkedList<Cat> catQueue = new LinkedList<>();
    private LinkedList<Dog> dogQueue = new LinkedList<>();
    int order;

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if(animal instanceof Cat) {
            catQueue.add((Cat) animal);
        } else if (animal instanceof Dog) {
            dogQueue.add((Dog) animal);
        }
    }

    public Cat dequeueCat() {
        return catQueue.remove();
    }

    public Dog dequeueDog() {
        return dogQueue.remove();
    }

    public Animal dequeueAny() {
        if(catQueue.isEmpty()) {
            return dequeueDog();
        } else if(dogQueue.isEmpty()) {
            return dequeueCat();
        }
        Cat cat = catQueue.peek();
        Dog dog = dogQueue.peek();

        if (cat.getOrder() > dog.getOrder()) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public static void main(String[] args) {
        Cat c = new Cat("asd");
        AnimalQueue a = new AnimalQueue();
        a.enqueue(new Dog("aaa"));
        a.enqueue(c);

        a.enqueue(new Dog("lll"));
        a.enqueue(new Dog("ttt"));
        a.enqueue(new Cat("sdf"));

        Cat b = a.dequeueCat();
        System.out.println(b.name);
        Dog d = a.dequeueDog();
        System.out.println(d.name);
        d = a.dequeueDog();
        System.out.println(d.name);

    }
}

class Animal {
    String name;
    int order;

    public Animal(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}
