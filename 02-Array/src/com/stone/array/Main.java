package com.stone.array;

public class Main {
    public static void main(String[] args) {
        Array array = new Array(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.addFirst(98);
        System.out.println(array);

        array.set(1, -100);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

        array.removeLast();
        System.out.println(array);

        array.remove(1);
        System.out.println(array);

        array.removeElement(-100);
        System.out.println(array);

        for (int i = 0; i < 3; i++) {
            array.removeFirst();
            System.out.println(array);
        }

    }
}
