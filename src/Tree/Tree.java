package Tree;

import Tree.Tree.Color;

public class Tree {
    Node root;
    class Node{
        int value;
        Node left;
        Node right;
        Color color;
    }
    public void insert(int value){
        if (root != null) {
          insert(root, value);  
        }else{
            root = new Node();
            root.value = value;
           }
        
    }
    enum Color{
        BLACK,
        RED
    }
    private void insert(Node node, int value){
        if(node.value != value){
            if(node.value < value){
                if(node.right == null){
                    node.right = new Node();
                    node.right.value = value;}else{
                        insert(node.right, value);}
                }
            }else{
                if(node.left == null){
                    node.left = new Node();
                    node.left.value = value;}else{
                        insert(node.left, value);}
            }
        }
    public Node find(int value){
        return find(root, value);
    }
    private Node find(Node node, int value ){
        if(node == null){
            return null;
        }if(node.value ==value){
            return node;
        }if(node.value < value){
            return find(node.right, value);
        }else{
            return find(node.left , value);
        }
    }
    private Node leftRotate(Node node){
        Node cur = node.right;
        node.right = cur.left;
        cur.left = node;
        cur.color = node.color;
        node.color= Color.RED;
        return cur;
    }
    private Node rightRotate(Node node){
        Node cur = node.left;
        node.left = cur.right;
        cur.right = node;
        cur.color = node.color;
        node.color= Color.RED;
        return cur;
    }
    private void swspColor(Node node){
        node.color = (node.color == Color.RED ? Color.BLACK : Color.RED);
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }
    private Node balanc(Node node){
        boolean flag = true;
        Node cur = node;
        do{
            flag = false;

            if(cur.right != null && cur.right.color == Color.RED && (cur.left == null || cur.left.color == Color.BLACK)){
                cur = leftRotate(cur);
                flag = true;
            }
            if(cur.left != null && cur.left.color == Color.RED && cur.left.left != null && cur.left.left.color == Color.RED){
                cur = rightRotate(cur);
                flag = true;
            }
            if(cur.left != null && cur.left.color == Color.RED && cur.right != null && cur.right.color == Color.RED){
                swspColor(cur);
                flag = true;
            }
        }while (flag);
        return  cur;
    }
}


