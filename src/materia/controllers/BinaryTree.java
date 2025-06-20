package materia.controllers;

import materia.models.Node;

public class BinaryTree {

    private Node root;
    private int size;

    public BinaryTree(){
        this.root = null;
        this.size = 0;
    }
    
    public void insert(int value){
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value){
        if (padre == null){
            size++;
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
    public boolean findeValue(int value){
        return searchRec(root, value);
    }

    private boolean searchRec(Node node, int value){
        if (node == null) {
            return false;
        }
        if (node.getValue() == value) {
            return true;
        }
        if (value < node.getValue()) {
            return searchRec(node.getIzquierdo(), value);
        } else {
            return searchRec(node.getDerecho(), value);
        }
    }

    public int getHeightTree(){
        return getHeightRec(root);
    }

    public int getHeightRec(Node node){
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeightRec(node.getIzquierdo());
        int rightHeight = getHeightRec(node.getDerecho());
        return Math.max(leftHeight, rightHeight)+1;
    }
    public void printInOrderWith(){
        printInOrderRecWith(root);
    }

    private void printInOrderRecWith(Node node){
        if (node != null){
            printInOrderRecWith(node.getIzquierdo());
            int height = getHeightRec(node);
            System.out.print(node.getValue() + "(h=" + height +"), ");
            printInOrderRecWith(node.getDerecho());
        }
    }

    public int getSize(){
        return size;
    }

    public void printInOrderBalanceFactor() {
        printInOrderBalanceFactorRec(root);
        System.out.println();
    }

    private void printInOrderBalanceFactorRec(Node node) {
        if (node != null) {
            printInOrderBalanceFactorRec(node.getIzquierdo());
            int bf = getHeightRec(node.getIzquierdo()) - getHeightRec(node.getDerecho());
            System.out.print(node.getValue() + "(bf=" + bf + "), ");
            printInOrderBalanceFactorRec(node.getDerecho());
        }
    }

    public boolean isBalanced() {
        return checkBalanced(root);
    }

    private boolean checkBalanced(Node node) {
        if (node == null) return true;
        int lh = getHeightRec(node.getIzquierdo());
        int rh = getHeightRec(node.getDerecho());
        int balance = lh - rh;
        return Math.abs(balance) <= 1 && checkBalanced(node.getIzquierdo()) && checkBalanced(node.getDerecho());
    }

    public void printUnbalancedNodes() {
        System.out.print("Nodos desequilibrados ");
        printUnbalancedRec(root);
        System.out.println();
    }

    private void printUnbalancedRec(Node node) {
        if (node != null) {
            printUnbalancedRec(node.getIzquierdo());
            int bf = getHeightRec(node.getIzquierdo()) - getHeightRec(node.getDerecho());
            if (Math.abs(bf) > 1) {
                System.out.print(node.getValue() + "(fE = " + bf + ") y ");
            }
            printUnbalancedRec(node.getDerecho());
        }
    }

    
}