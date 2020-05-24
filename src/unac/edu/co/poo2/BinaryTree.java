package unac.edu.co.poo2;
import java.util.LinkedList;

public class BinaryTree {
        protected Node root;

        public BinaryTree() {
            root = null;
        }

        public BinaryTree(Node raiz) {
            this.root = raiz;
        }

        public Node TreeRoot() {
            return root;
        }

        // Comprueba el estatus del árbol
        boolean esVacio() {
            return root == null;
        }

        public static Node NewTree(Node leftRoot, Object dato, Node RightRoot) {
            return new Node(leftRoot, dato, RightRoot);
        }


        public static void imprimirPorNiveles(Node raiz) throws Exception {
            Cola cola = new Cola();
            cola.insertar(raiz);
            int i = 1;
            while (!cola.colaVacia()){
                Node aux = (Node)cola.quitar();
                System.out.println(aux.date);
                if (aux.subTreeL() != null){
                    cola.insertar(aux.subTreeL());
                }
                if (aux.subTreeR() != null){
                    cola.insertar(aux.subTreeR());
                }
                i++;
            }
        }

        //Recorrido de un arbol binario en preorden
        public static void preorden(Node r){
            if (r != null){
                r.visited();
                preorden(r.subTreeL());
                preorden(r.subTreeR());
            }
        }

        // Recorrido de un árbol binario en inorden
        public static void inorden(Node r) {
            if (r != null) {
                inorden (r.subTreeL());
                r.visited();
                inorden (r.subTreeR());
            }
        }

        // Recorrido de un árbol binario en postorden
        public static void postorden(Node r) {
            if (r != null) {
                postorden (r.subTreeL());
                postorden (r.subTreeR());
                r.visited();
            }
        }

        public static int numNodos(Node raiz) {
            if (raiz == null)
                return 0;
            else
                return 1 + numNodos(raiz.subTreeL()) + numNodos(raiz.subTreeR());
        }

        public static int altura(Node raiz){
            if (raiz == null)
                return 0;
            else{
                int alturaIzq = altura(raiz.subTreeL());
                int alturaDer = altura(raiz.subTreeR());
                if (alturaIzq > alturaDer)
                    return alturaIzq + 1;
                else
                    return alturaDer + 1;
            }
        }



        public static boolean fullTree(Node root){
            if (root == null)
                return true;
            else if (altura(root.subTreeL()) != altura(root.subTreeR()))
                return false;
            return fullTree(root.subTreeL()) && fullTree(root.subTreeR());
        }
}
