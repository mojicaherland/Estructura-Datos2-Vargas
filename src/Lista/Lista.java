package Lista;

public class Lista {
    private int max;
    private int cantElem;
    private int[] arreglo;

    //Constructor
    public Lista(int max) {
        this.max = max;
        this.cantElem = 0;
        this.arreglo = new int[max];
    }

    public String toString() {
        String s1 = "[";
        int i = 0;
        while (i < this.cantElem) {
            if (i == this.cantElem - 1) {
                s1 = s1 + this.arreglo[i];
            } else {
                s1 = s1 + this.arreglo[i] + ", ";
            }
            i++;
        }
        return s1 + "]";
    }

    //imprimir la lista
    public void imprimirLista(Lista lista) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
    }

    //Otros metodos
    public void insertarIesimo(int x, int i) {
        int k = this.cantElem - 1;
        while (k >= i) {
            this.arreglo[k + 1] = this.arreglo[k];
            k = k - 1;
        }
        this.arreglo[i] = x;
        this.cantElem++;
    }

    public void insertarPrimero(int x) {
        insertarIesimo(x, 0); //t(n) = n
    }

    public void insertarUltimo(int x) {
        insertarIesimo(x, this.cantElem); //t(n)=1
    }

    public void elimarIesimo(int i) {
        int k = i + 1;
        while (k < this.cantElem) {
            this.arreglo[k - 1] = this.arreglo[k];
            k++;
        }
        this.cantElem--;
    }

    public void elimarPrimero() {
        this.elimarIesimo(0);
    }

    public void eliminarUltimo() {
        this.elimarIesimo(this.cantElem - 1);
    }

    public void eliminarTodo(int x) { //elimina datos repetidos de un vector
        int i = 0;
        while (i < this.cantElem) {
            if (this.arreglo[i] == x) {
                this.elimarIesimo(i);
            } else {
                i++;
            }
        }
    }

    //Ejercicios del anterior clase martes 12/03/2024
    public void eliminarPares() {//eliminar elementos pares de un vector
        int i = 0;
        while (i < this.cantElem) {
            if (this.arreglo[i] % 2 == 0) {
                this.elimarIesimo(i);
            }
            i++;
        }
    }

    public void eliminarUnicos() { //elimina datos no-repetidos

    }

    public void eliminarDatosDeUnaListaEnOtraLista() {
    }

    // 7. L1.pasarDigitos( n ) : Método que pasa los dígitos del entero n,
    // a la Lista L1. Ejemplo: Si n = 546781, L1 = []. El resultado es L1 = [5, 4, 6, 7, 8, 1]
    public void pasarDigitos(int n) {
        while (n > 0) {
            int aux = n % 10;
            n = n / 10;
            this.insertarPrimero(aux);

        }

    }

    //8. L1.rotarIzqDer( n ) : Método que hace rotar
// los elementos de la lista L1 n-veces de izquierda a derecha. Sugerencia, utilizar los métodos de insertar y eleminar por los extremos de la Lista.
    public void rotarIzqDer(int n) {
        while (n > 0) {
            int copia = this.arreglo[this.cantElem - 1];
            this.eliminarUltimo();
            this.insertarPrimero(copia);
            n--;
        }
    }

    //9. L1.rotarDerIzq( n ) : Método que hace rotar los
    // elementos de la lista L1 n-veces de derecha a izquierda.
    public void rotarDerIzq(int n) {
        while (n > 0) {
            int copia = this.arreglo[0];
            this.elimarPrimero();
            this.insertarUltimo(copia);
            n--;
        }
    }

    //10. L1.eliminarPrim( n ) : Método que eliminar
    // los primeros n-elementos de la lista L1.
    public void eliminarPrim(int n) {
        while (n > 0) {
            this.elimarPrimero();
            n--;
        }
    }

    //11. L1.eliminarUlt( n ) : Método que elimina los n-últimos elementos de la lista L1.
    public void eliminarUlt(int n) {
        while (n > 0) {
            this.eliminarUltimo();
            n--;
        }
    }

    //12. L1.insertarIesimo(L2, i) : Método que inserta
    // la Lista L2 en la Lista L1, en la posición i.
    public void insertarIesimo2(Lista l2, int i) {
        int cant = l2.cantElem;
        for (int j = 0; j < cant; j++) {
            this.insertarIesimo(l2.arreglo[j], i-1);
            i++;
        }
    }
}
