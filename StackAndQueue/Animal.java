package StackAndQueue;

import java.util.LinkedList;

abstract class Animal {
    private int order;
    protected String name;
    public Animal(String n) { name = n; }
    public void setOrder(int ord) { order = ord; }
    public int getOrder() { return order; }

    /* Compare orders of animals to return the order item. */
    public boolean isOrderThan(Animal a) {
        return this.order < a.getOrder();
    }
}


class Dog extends Animal {
    public Dog(String n) {
        super(n);
    }
}

class Cat extends Animal {
    public Cat(String n) {
        super(n);
    }
}

class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0; //Time stamp.

    public void enqueue(Animal a) {
        a.setOrder(order);
        order += 1;

        if (a instanceof Dog) dogs.addLast((Dog) a);
        else if (a instanceof Cat) cats.addLast((Cat) a);
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0) {
            return dequeueDogs();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOrderThan(cat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }
}

