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
    public void saludar() {
        //System.out.println("Hola");
    }

    //Lab 3- Mas Sobre listas en arreglo --> 21/03/2024
    //4. L1.insertarLugasAsc(x) : Método que inserta el elemento x,
    // en su lugar correspondiente en la Lista L1, ordenada de menor a mayor.
    public void insertarLugarAsc(int x) {
        for (int i = 0; i < this.cantElement - 1; i++) {
            if (x > this.arreglo[i] && x < this.arreglo[i + 1]) {
                this.insertarIesimo(x, i + 1);
                break;
            }
        }
    }

    //5. L1.insertarLugasDesc(x) : Método que inserta el elemento x,
    // en su lugar correspondiente en la Lista L1, ordenada de mayor a menor.
    public void insertarLugarDesc(int x) {
        for (int i = 0; i < this.cantElement; i++) {
            if (x < this.arreglo[i] && x > this.arreglo[i + 1]) {
                this.insertarIesimo(x, i + 1);
                break;
            }
        }
    }

    //6. L1.comunes(L2, L3) : Método que encuentra en L1, los elementos comunes en las Listas L2, L3.
    public void comunes(ListaPrueba l2, ListaPrueba l3) {
        for (int i = 0; i < this.cantElement; i++) {
            for (int j = 0; j < l2.cantElement; j++) {
                for (int k = 0; k < l3.cantElement; k++) {
                    if (this.arreglo[i] == l2.arreglo[j] && this.arreglo[i] == l3.arreglo[k]) {
                        System.out.println(this.arreglo[i]);
                    }
                }
            }
        }
    }

    //7. L1.intercalar(L2, L3) : Método que encuentra en L1, los elementos intercalados de las Listas L2 y L3.
    public void intercalar(ListaPrueba l2, ListaPrueba l3) {
        int i = 0;
        int j = 0;
        while (i < l2.cantElement && j < l3.cantElement) {
            this.insertarUltimo(l2.arreglo[i]);
            this.insertarUltimo(l3.arreglo[j]);
            i++;
            j++;
        }
        while (i < l2.cantElement) {
            this.insertarUltimo(l2.arreglo[i]);
            i++;
        }
        while (j < l3.cantElement) {
            this.insertarUltimo(l3.arreglo[j]);
            j++;
        }
    }

    //8. L1.ordenado() : Método lógico que devuelve True,
    // si los elementos de la lista L1, están ordenados en forma ascendente o descendente.
    public boolean ordenado() {
        boolean asc = true;
        boolean desc = true;
        for (int i = 0; i < this.cantElement - 1; i++) {
            if (this.arreglo[i] > this.arreglo[i + 1]) {
                asc = false;
            }
            if (this.arreglo[i] < this.arreglo[i + 1]) {
                desc = false;
            }
        }
        return asc || desc;
    }

    //9. L1.iguales() : Método lógico que devuelve True, si todos los elementos de la lista L1, son iguales.
    public boolean iguales() {
        for (int i = 0; i < this.cantElement - 1; i++) {
            if (this.arreglo[i] != this.arreglo[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //10. L1.diferentes() : Método lógico que devuelve True,
    // si todos los elementos de la lista L1, son diferentes.
    public boolean diferentes() {
        for (int i = 0; i < this.cantElement - 1; i++) {
            if (this.arreglo[i] != this.arreglo[i + 1]) {
                return true;
            }
        }
        return false;
    }

    //11. L1.menor() : Método que devuelve el menor elemento de la Lista L1.
    public int menor() {
        return 0; //falta
    }

    //12. L1.parImpar() : Método lógico que devuelve True,
    // en la Lista L1, existe al menos un elemento par y al menor un elemento impar.
    public boolean parImpar() {
        boolean par = false;
        boolean impar = false;
        for (int i = 0; i < this.cantElement; i++) {
            if (this.arreglo[i] % 2 == 0) {
                par = true;
            } else {
                impar = true;
            }
        }
        return par && impar;
    }

    //13. L1.mismaFrec() : Método lógico que devuelve True,
    // si todos los elementos tienen la misma frecuencia de aparición en la Lista L1.
    public boolean mismaFrec() {
        return true;
    }

    //14. L1.palindrome() : Método lógico que devuelve True,
    // si los elementos de la Lista L1, forma un palíndrome.
    public boolean palindrome() {
        return true;
    }

    //15. L1.mismosElem(L2) : Método lógico que devuelve True,
    // las Lista L1 y L2 tienen los mismos elementos.
    public boolean mismosElem(ListaPrueba l2) {
        return true;
    }
}
