package unac.edu.co.poo2;

public class Cola {
    protected NodeCola front;
    protected NodeCola end;

    // constructor: crea cola vacía
    public Cola() {
        front = end = null;
    }

    // insertar: pone elemento por el final
    public void insertar(Object elemento) {
        NodeCola a;
        a = new NodeCola(elemento);
        if (colaVacia()) {
            front = a;
        } else {
            end.siguiente = a;
        }
        end = a;
    }

    // quitar: sale el elemento frente
    public Object quitar() throws Exception {
        Object aux;
        if (!colaVacia()) {
            aux = front.elemento;
            front = front.siguiente;
        } else
            throw new Exception("Eliminar de una cola vacía");
        return aux;
    }

    // libera todos los nodos de la cola
    public void borrarCola() {
        for (; front != null;) {
            front = front.siguiente;
        }
        System.gc();
    }

    // acceso al primero de la cola
    public Object frenteCola() throws Exception {
        if (colaVacia()) {
            throw new Exception("Error: cola vacía");
        }
        return (front.elemento);
    }

    // verificación del estado de la cola
    public boolean colaVacia() {
        return (front == null);
    }
}
