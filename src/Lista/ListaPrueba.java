package Lista;

public class ListaPrueba {
    private int max;
    private int cantElement;
    private int[] arreglo;

    //Constructor
    public ListaPrueba(int max) {
        this.max = max;
        this.cantElement = 0;
        this.arreglo = new int[max];
    }

    //Metodo para imprimir la lista --> otra forma a la principal
    public String toString() {
        String s1 = "[";
        for (int i = 0; i < this.cantElement; i++) {
            if (i == this.cantElement - 1) {
                s1 = s1 + this.arreglo[i];
            } else {
                s1 = s1 + this.arreglo[i] + ", ";
            }
        }
        return s1 + "]";
    }

    //Otros metodos
    public void insertarIesimo(int dato, int posAInsertar) {//inserta un dato en unna posicion especifica
        int k = this.cantElement - 1;//posicion en la ultima de la lista
        while (k >= posAInsertar) {
            this.arreglo[k + 1] = this.arreglo[k];
            k--;
        }
        this.arreglo[posAInsertar] = dato;
        this.cantElement++;
    }

    //inserta en la primera posicion de la lista un dato
    public void insertarPrimero(int dato) {
        insertarIesimo(dato, 0);
    }

    //inserta el la ultima posicion de la lista un dato
    public void insertarUltimo(int dato) {
        insertarIesimo(dato, this.cantElement);
    }

    //elimina un dato de una posicion
    public void eliminarIesimo(int pos) {
        int k = pos + 1;
        while (k < this.cantElement) {
            this.arreglo[k - 1] = this.arreglo[k];
            k++;
        }
        this.cantElement--;
    }

    //elimina el primer elemento de la lista
    public void eliminarPrimero() {
        eliminarIesimo(0);
    }

    //elimina el ultimo dato de la lista
    public void eliminarUltimo() {
        eliminarIesimo(this.cantElement - 1);
    }

    public void eliminarTodo(int dato) { //elimina datos repetidos de una lista
        int i = 0;
        while (i < this.cantElement) {
            if (this.arreglo[i] == dato) {
                this.eliminarIesimo(i);
            } else {
                i++;
            }
        }
    }

    //elimina pares de la lista
    public void eliminarPares() {
        int i = 0;
        while (i < this.cantElement) {
            if (this.arreglo[i] % 2 == 0) {
                this.eliminarIesimo(i);
            } else {
                i++;
            }
        }
    }

    //elimina datos no-repetidos de la lista
    public void eliminarUnicos() {
        int i = 0;
        while (i < this.cantElement) {
            boolean esUnico = true;
            for (int j = 0; j < this.cantElement; j++) {
                if (i != j && this.arreglo[i] == this.arreglo[j]) {
                    esUnico = false;
                    break;
                }
            }
            if (esUnico) {
                this.eliminarIesimo(i);
            } else {
                i++;
            }
        }
    }

    //Método que elimina todos los elementos de la lista L1, que aparecen en la lista L2.
    public void eliminarTodo(ListaPrueba l2) {
        int i = 0;
        while (i < this.cantElement) {
            boolean encontrado = false;
            for (int j = 0; j < l2.cantElement; j++) {
                if (this.arreglo[i] == l2.arreglo[j]) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                this.eliminarIesimo(i);
            } else {
                i++;
            }
        }
    }

    //Método que pasa los dígitos del entero n,
    // a la Lista L1. Ejemplo: Si n = 546781, L1 = []. El resultado es L1 = [5, 4, 6, 7, 8, 1]
    public void pasarDigitos(int n) {
        while (n > 0) {
            int dig = n % 10;
            n = n / 10;
            this.insertarPrimero(dig);
        }
    }

    //Método que hace rotar los elementos de la lista L1 n-veces de izquierda a derecha.
    // Sugerencia, utilizar los métodos de insertar y eleminar por los extremos de la Lista.
    public void rotarIzqDer(int n) {
        while (n > 0) {
            int copia = this.arreglo[this.cantElement - 1];
            this.eliminarUltimo();
            this.insertarPrimero(copia);
            n--;
        }
    }

    // Método que hace rotar los elementos de la lista L1 n-veces de derecha a izquierda.
    public void rotarDerIzq(int n) {
        while (n > 0) {
            int copia = this.arreglo[0];
            this.eliminarPrimero();
            this.insertarUltimo(copia);
            n--;
        }
    }

    // Método que eliminar los primeros n-elementos de la lista L1.
    public void eliminarPrim(int n) {
        while (n > 0) {
            this.eliminarPrimero();
            n--;
        }
    }

    //Método que elimina los n-últimos elementos de la lista L1.
    public void eliminarUlt(int n) {
        while (n > 0) {
            this.eliminarUltimo();
            n--;
        }
    }

    //----TAREA PARA EL DIA MARTES----//

    //Método que insertar los elementos de la lista L2 en la lista L1, desde la posición i.
    public void insertarIesimo(ListaPrueba l2, int i) {
        for (int j = 0; j < l2.cantElement; j++) {
            this.insertarIesimo(l2.arreglo[j], i);
            i++;
        }
    }

    //Método que insertar los elementos de la lista L2 al principio de la lista L1.
    public void insertarPrim(ListaPrueba l2) {
        for (int i = l2.cantElement - 1; i >= 0; i--) {
            this.insertarPrimero(l2.arreglo[i]);
        }
    }

    // Método que insertar los elementos de la lista L2 al final de la lista L1.
    public void insertarUlt(ListaPrueba l2) {
        for (int i = 0; i < l2.cantElement; i++) {
            this.insertarUltimo(l2.arreglo[i]);
        }
    }

    // L1.eliminarIesimo(i, n) : Método que elimina los n-elementos de la lista L1, desde la posición i.
    public void eliminarIesimo(int i, int n) {
        for (int j = 0; j < n; j++) {
            this.eliminarIesimo(i);
        }
    }

    //: Método que eliminar la n-elementos de los extremos de la lista L1.
    public void eliminarExtremos(int n) {
        for (int i = 0; i < n; i++) {
            this.eliminarPrimero();
            this.eliminarUltimo();
        }
    }

    //Método que elimina los elementos que se repiten k-veces en la lista L1.
    public void eliminarVeces(int k) { // no sirve
        for (int i = 0; i < k; i++) {
            this.eliminarTodo(k);
        }
    }

    //L1.eliminarAlternos() : Método que elimina los elementos
    // de las posiciones alternas. (permanece, se elimina, permanece, se elimina, etc.)

}
