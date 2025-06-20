import materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree ab = new BinaryTree();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

        System.out.println("\nNombre: Wellington Guzmán");

        System.out.println("\nPosOrder");
        ab.printPosOrder();

        System.out.println("\nPreOrder");
        ab.printPreOrder();

        System.out.println("\nInOrder");
        ab.printInOrder();

        System.out.println("\nArbol InOrder Alturas");
        ab.printInOrderWith();
        System.out.println("\nPeso de arbol: "+ ab.getSize());

        if (ab.findeValue(23)) {
            System.out.println("Encontro el valor de 23");
        }else{
            System.out.println("No se encontro el valor 23");
        }

        if (ab.findeValue(77)) {
            System.out.println("Encontro el valor 77");
        }else{
            System.out.println("No se encontro el valor 77");
        }

        System.out.println("Altura es = " + ab.getHeightTree());

        System.out.println("\nArbol InOrder");
        ab.printInOrder();

        System.out.println("\nArbol InOrder con alturas");
        ab.printInOrderWith();

        System.out.println("\nArbol InOrder con factor de equilibrio");
        ab.printInOrderBalanceFactor();

        System.out.println("\nArbol esta equilibrado = " + ab.isBalanced());

        int nuevoValor = 15;
        System.out.println("Existe el nodo " + nuevoValor + "= " + ab.findeValue(nuevoValor));
        System.out.println("Agregamos valor = " + nuevoValor);
        ab.insert(nuevoValor);

        System.out.println("Arbol esta equilibrado = " + ab.isBalanced());

        System.out.println("\nArbol InOrder con factor de equilibrio");
        ab.printInOrderBalanceFactor();

        ab.printUnbalancedNodes();
    }
}
