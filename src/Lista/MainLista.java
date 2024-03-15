package Lista;

public class MainLista {
    public static void main(String[] args) {
        Lista lista = new Lista(20);
        Lista l2 = new Lista(20);

//        lista.insertarPrimero(10);
//        lista.insertarPrimero(20);
//        lista.insertarUltimo(50);
//        lista.insertarPrimero(80);
//        System.out.println(lista.toString());
//        lista.elimarPrimero();
//        lista.eliminarUltimo();
//       System.out.println(lista);

      lista.pasarDigitos(546781);
      System.out.println(lista.toString());
//        lista.rotarIzqDer(1);
//        System.out.println(lista.toString());
//        lista.rotarDerIzq(1);
//        System.out.println(lista.toString());
//        lista.eliminarPrim(2);
//        System.out.println(lista.toString());
//        lista.eliminarUlt(2);
//        System.out.println(lista.toString());

        l2.pasarDigitos(123);
        System.out.println(l2.toString());
        lista.insertarIesimo2(l2,2);
        System.out.println(lista.toString());
    }
}
