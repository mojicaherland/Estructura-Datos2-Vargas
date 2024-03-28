package Nodo;

public class MainListaEnlazada {
    public static void main(String[] args) {
        ListaEnlazada l = new ListaEnlazada();

        l.insertarIesimo(1, 0);
        l.insertarIesimo(2, 1);
        l.insertarIesimo(3, 2);

        System.out.println(l.toString());
    }
}
