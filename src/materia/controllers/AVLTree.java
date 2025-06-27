package materia.controllers;

import materia.models.Node;

public class AVLTree {
    private Node root;


    public AVLTree(){
        root=null;
    }

    public void insert(int value){
        root= insertRec(root,value);
    }

    private Node insertRec(Node node, int value){
        if( node==null){
            Node newNode= new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo insertado -> "+value+" con balance "+getBalance(newNode));
            return newNode;
        }
        if (value < node.getValue()) {
        node.setIzquierdo(insertRec(node.getIzquierdo(), value));

        } else if (value > node.getValue()) {
        node.setDerecho(insertRec(node.getDerecho(), value));

        }else{
        return node;
        }

        System.out.println("Node actual ->" + node.getValue());

        int altura = 1 + Math.max(height(node.getIzquierdo()), height(node.getDerecho()));
        node.setHeight(altura);
        System.out.println("\tAltura ->" + altura);

        int balance = getBalance(node);
        System.out.println("\tBalance ->" + balance);

        if (balance > 1 && value < node.getIzquierdo().getValue()) {
            System.out.println("Rotacion simple derecha");
            return rightRotation(node);
        }
        if (balance < -1 && value > node.getDerecho().getValue()) {
            System.out.println("Rotacion simpre isquierda");
            return leftRotation(node);
        }
        if (balance > 1&& value > node.getIzquierdo().getValue()) {
            System.out.println("Cambio");
            System.out.println("Rotacion simple derecha");
            return rightRotation(node);
        }

        if (balance < -1 && value < node.getDerecho().getValue()) {
            System.out.println("Cambio");
            node.setDerecho(rightRotation(node.getDerecho()));
            System.out.println("Rotacion simpre izquierda");
            return leftRotation(node);
        }

        return node;

    }

    private int height(Node node){

        if (node==null){
            return 0;
        }else{
            return node.getHeight();
        }
    }

    private int getBalance(Node node){
        if (node == null) {
            return 0;
        }
        return height(node.getIzquierdo()) - height(node.getDerecho());
    }
    
    public Node leftRotation(Node x){
        Node y = x.getDerecho();
        Node temp = y.getIzquierdo();
        System.out.println("Rotacion IZQ en node: "+ x.getValue() + ", con balance = "+ getBalance(x));
        y.setIzquierdo(x);
        x.setDerecho(temp);
        x.setHeight(Math.max(height(x.getIzquierdo()), height(x.getDerecho()))+1);
        y.setHeight(Math.max(height(y.getIzquierdo()), height(y.getDerecho()))+1);

        System.out.println("Nueva raiz despues de la rotacion "+ y.getValue());
        return y;

    }

    private Node rightRotation(Node y){
        Node x = y.getIzquierdo();
        Node temp = x.getDerecho();
        System.out.println("Rotacion DER en node: "+ y.getValue() + ", con balance = "+ getBalance(y));
        x.setDerecho(y);
        y.setIzquierdo(temp);

        y.setHeight(Math.max(height(y.getIzquierdo()), height(y.getDerecho()))+1);
        x.setHeight(Math.max(height(x.getIzquierdo()), height(x.getDerecho()))+1);

        System.out.println("Nueva raiz despues de la rotacion "+ x.getValue());
        return x;
        

    }

}