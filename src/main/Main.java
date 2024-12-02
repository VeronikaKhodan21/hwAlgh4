package main;

import Tree.Tree;
import hashMapp.HashMapp;

public class Main {
    public static void main(String[] args) {
        int max = 20;
        Tree tree = new Tree();
        for (int i = 1; i <= max; i++) {
            tree.insert(i);
        }  
        tree.print();
    }
    public void HashMapp(){
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