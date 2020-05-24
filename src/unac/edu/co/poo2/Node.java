package unac.edu.co.poo2;

public class Node {
    protected Object date;
    protected Node left;
    protected Node right;

    public Node(Object valor){
        date = valor;
        left = right = null;
    }

    public Node(Node leftRoot, Object valor, Node RightRoot){
        date = valor;
        left = leftRoot;
        right = RightRoot;
    }

    public Object valueNode(){
        return date;
    }

    public Node subTreeL(){
        return left;
    }

    public Node subTreeR(){
        return right;
    }

    public void NewValue(Object d){
        date = d;
    }

    public void leftRoot(Node n){
        left = n;
    }

    public void RightRoot(Node n){
        right = n;
    }

    public void leftRoot(){
        System.out.print(date + " ");
    }
    public void visited(){
        System.out.print(date + " ");
    }
}
