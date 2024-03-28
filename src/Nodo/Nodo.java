package Nodo;

public class Nodo {
    public int elem; //dato del nodo
    public Nodo prox; // puntero que apunta al sgt nodo

    public Nodo(int elem, Nodo prox) { //constructor
        this.elem = elem;
        this.prox = prox;
    }
}
