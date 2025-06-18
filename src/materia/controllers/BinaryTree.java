package materia.controllers;

import materia.models.Node;

public class BinaryTree {

    private Node root;

    public BinaryTree(){
        this.root = null;
    }
    
    public void insert(int value){
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value){
        if (padre == null){
            padre = new Node(value);
            return padre;
        }
        if (value < padre.getValue()){
            padre.setIzquierdo(insertRec(padre.getIzquierdo(), value));
        } else if (value > padre.getValue()){
            padre.setDerecho(insertRec(padre.getDerecho(), value));
        }
        return padre;
    }

    public void printPosOrder(){
        printPosOrderRec(root);
    }

    private void printPosOrderRec(Node node){
        if (node != null){
            printPosOrderRec(node.getIzquierdo());
            printPosOrderRec(node.getDerecho());
            System.out.print(node.getValue() + ", ");
        }
    }

    public void printPreOrder(){
        printPreOrderRec(root);
    }

    private void printPreOrderRec(Node node){
        if (node != null){
            System.out.print(node.getValue() + ", ");
            printPreOrderRec(node.getIzquierdo());
            printPreOrderRec(node.getDerecho());
        }
    }

    public void printInOrder(){
        printInOrderRec(root);
    }

    private void printInOrderRec(Node node){
        if (node != null){
            printInOrderRec(node.getIzquierdo());
            System.out.print(node.getValue() + ", ");
            printInOrderRec(node.getDerecho());
        }
    }
    
    public boolean findeValue(int value) {
        return searchInOrderRec(root, value) 
            || searchPreOrderRec(root, value) 
            || searchPostOrderRec(root, value);
    }

    private boolean searchInOrderRec(Node node, int value) {
        if (node == null) return false;
        return searchInOrderRec(node.getIzquierdo(), value)
            || node.getValue() == value
            || searchInOrderRec(node.getDerecho(), value);
    }

    private boolean searchPreOrderRec(Node node, int value) {
        if (node == null) return false;
        return node.getValue() == value
            || searchPreOrderRec(node.getIzquierdo(), value)
            || searchPreOrderRec(node.getDerecho(), value);
    }

    private boolean searchPostOrderRec(Node node, int value) {
        if (node == null) return false;
        return searchPostOrderRec(node.getIzquierdo(), value)
            || searchPostOrderRec(node.getDerecho(), value)
            || node.getValue() == value;
    }

}