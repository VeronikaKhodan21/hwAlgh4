package main;

import hashMapp.HashMapp;

public class Main {
    public static void main(String[] args) {
        HashMapp map = new HashMapp();
        map.push(1,2);
        map.push(3,4);
        System.out.println(map.find(1));
        System.out.println(map.find(2));

        map.remove(1);
        map.push(2, 5);

        System.out.println(map.find(1));
        System.out.println(map.find(2));
    }
}