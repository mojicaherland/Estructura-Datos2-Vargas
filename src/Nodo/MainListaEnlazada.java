package Nodo;

public class MainListaEnlazada {
    public static void main(String[] args) {

        ListaEnlazada listaEnlazada = new ListaEnlazada();
        ListaEnlazada listaEnlazada2 = new ListaEnlazada();

        listaEnlazada.insertarIesimo(10, 0);
        listaEnlazada.insertarIesimo(20, 1);
        listaEnlazada.insertarIesimo(30, 2);
        listaEnlazada.insertarIesimo(40, 3);
        listaEnlazada.insertarIesimo(20, 4);
        System.out.println("Lista1: " + listaEnlazada.toString());

        listaEnlazada2.insertarIesimo(1, 0);
        listaEnlazada2.insertarIesimo(2, 1);
        System.out.println("Lista2: " + listaEnlazada2.toString());

        listaEnlazada.insertarUlt(listaEnlazada2);
        System.out.println(listaEnlazada);
    }
}
