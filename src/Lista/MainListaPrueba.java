package Lista;

public class MainListaPrueba {
    public static void main(String[] args) {
        ListaPrueba listaPrueba = new ListaPrueba(10);
        ListaPrueba l2 = new ListaPrueba(10);
        ListaPrueba l3 = new ListaPrueba(10);

        listaPrueba.insertarIesimo(1, 0);
        listaPrueba.insertarIesimo(2, 1);
        listaPrueba.insertarIesimo(2, 2);
        listaPrueba.insertarIesimo(5, 3);
        System.out.println("Lista 1: " + listaPrueba.toString());

        l2.insertarIesimo(10, 0);
        l2.insertarIesimo(20, 1);
        l2.insertarIesimo(30, 2);
        System.out.println("Lista 2: " + l2.toString());

//        l3.pasarDigitos(546781);
//        System.out.println(l3.toString());
//        l3.eliminarPrim(2);
//        System.out.println(l3.toString());

        listaPrueba.eliminarVeces(2);
        System.out.println("Lista Mesclada: " + listaPrueba.toString());
    }

}
