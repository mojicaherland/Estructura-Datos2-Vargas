package Lista;

public class MainListaPrueba {
    public static void main(String[] args) {
        Lista listaprueba = new Lista(10);

        listaprueba.insertarIesimo(10,0);
        listaprueba.insertarIesimo(20,1);
        listaprueba.insertarIesimo(30,2);
        listaprueba.insertarIesimo(40,3);

        System.out.println(listaprueba.toString());
    }

}
