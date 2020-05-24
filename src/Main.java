import unac.edu.co.poo2.BinaryTree;
import unac.edu.co.poo2.SearchTree;
import unac.edu.co.poo2.Student;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    static SearchTree add = new SearchTree();

    public static void main(String[] args)  throws Exception{
        BinaryTree arbol = new BinaryTree();
        System.out.println("Carné           Nombre                                   Email");
        tree();
        System.out.println("");
        System.out.print("Inorden: ");
        BinaryTree.inorden(add.TreeRoot());
        System.out.println("");
        System.out.print("Preorden: ");
        BinaryTree.preorden(add.TreeRoot());
        System.out.println("");
        System.out.print("Postorden: ");
        BinaryTree.postorden(add.TreeRoot());
        System.out.println("\n");
        System.out.println("Por Niveles ");
        BinaryTree.imprimirPorNiveles(add.TreeRoot());
        System.out.println("");
        System.out.println("Altura del Arbol: " + BinaryTree.altura(add.TreeRoot()) + " niveles");
        System.out.println("Cantidad de Nodos: " + BinaryTree.numNodos(add.TreeRoot()));
        System.out.println("Arbol lleno: " + BinaryTree.fullTree(add.TreeRoot()));
    }

    public static void tree(){
        try{
            FileReader file = new FileReader("estudiantes.txt");
            BufferedReader b = new BufferedReader(file);
            String linea;
            while ((linea = b .readLine()) != null){
                System.out.println(linea);
                String s= "";
                long t = 0;
                    for (int i=0 ; i< linea.length(); i++){
                        char a= linea.charAt((i));
                            if(a!= ' '){
                                s = s + (String.valueOf(a));
                            }else{
                                break;
                            }
                    }
                    t = Long.parseLong(s);
                    s= "";

                    for(int i=16;  i<linea.length(); i++){
                        char a = linea.charAt(i);
                            if (a !=  ' '){
                                s = s + (String.valueOf(a));
                            }else{
                                break;
                            }
                    }

                    String v ="";
                    for (int i= 58; i <linea.length(); i++  ){
                        char a = linea.charAt(i);
                        if(a != ' '){
                            v = v + (String.valueOf(a));
                        }else {
                            break;
                        }
                    }

                    Student student = new Student( t, s, v);
                    add.insertar(student);



            }

            file.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
