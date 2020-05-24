package unac.edu.co.poo2;

public class SearchTree extends BinaryTree{
    public SearchTree() {
        super();
    }

    public void insertar (Object valor )throws Exception {
        Comparated date;
        date = (Comparated) valor;
        root = insertar(root, date);
    }

    //método interno para realizar la operación
    protected Node insertar(Node raizSub, Comparated dato) throws Exception {
        if (raizSub == null)
            raizSub = new Node(dato);
        else if (dato.menorQue(raizSub.valueNode())) {
            Node iz;
            iz = insertar(raizSub.subTreeL(), dato);
            raizSub.leftRoot(iz);
        }
        else if (dato.mayorQue(raizSub.valueNode())) {
            Node dr;
            dr = insertar(raizSub.subTreeR(), dato);
            raizSub.RightRoot(dr);
        }
        else
            throw new Exception("Nodo duplicado");
        return raizSub;
    }

    public void eliminar (Object valor) throws Exception {
        Comparated date;
        date = (Comparated) valor;
        root = eliminar(root, date);
    }

    //método interno para realizar la operación
    protected Node eliminar (Node raizSub, Comparated dato) throws Exception {
        if (raizSub == null)
            throw new Exception ("No encontrado el nodo con la clave");
        else if (dato.menorQue(raizSub.valueNode())) {
            Node iz;
            iz = eliminar(raizSub.subTreeL(), dato);
            raizSub.leftRoot(iz);
        }
        else if (dato.mayorQue(raizSub.valueNode())) {
            Node dr;
            dr = eliminar(raizSub.subTreeR(), dato);
            raizSub.RightRoot(dr);
        }
        else{ // Nodo encontrado
            Node q;
            q = raizSub; // nodo a quitar del árbol
            if (q.subTreeL() == null)
                raizSub = q.subTreeR();
            else if (q.subTreeR() == null)
                raizSub = q.subTreeL();
            else { // tiene rama izquierda y derecha
                q = reemplazar(q);
            }
            q = null;
        }
        return raizSub;
    }

    // método interno para sustituir por el mayor de los menores
    private Node reemplazar(Node act) {
        Node a, p;
        p = act;
        a = act.subTreeL(); // rama de nodos menores
        while (a.subTreeR() != null) {
            p = a;
            a = a.subTreeR();
        }
        act.NewValue(a.valueNode());
        if (p == act)
            p.leftRoot(a.subTreeL());
        else
            p.RightRoot(a.subTreeL());
        return a;
    }
}
