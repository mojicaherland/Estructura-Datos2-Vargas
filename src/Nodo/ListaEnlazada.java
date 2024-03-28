package Nodo;

public class ListaEnlazada {
    public Nodo prim;
    public int cantElem;
    public Nodo ult;

    public ListaEnlazada() {
        prim = ult = null;
        cantElem = 0;
    }

    public String toString() {
        String s1 = "[";
        Nodo p = prim;
        while (p != null) {
            s1 = s1 + p.elem;
            if (p.prox != null) {
                s1 = s1 + ", ";
            }
            p = p.prox;
        }
        return s1 + "]";
    }

    //Metodos de listas enlazadas

    public boolean vacia() {
        return ((prim == null) && (ult == null));
    }

    public void insertarPrim(int x) {
        if (vacia()) {
            prim = ult = new Nodo(x, null);
        } else {
            prim = new Nodo(x, prim);
        }
        cantElem++;
    }

    public void insertarUlt(int x) {
        if (vacia()) {
            prim = ult = new Nodo(x, null);
        } else {
            ult = ult.prox = new Nodo(x, null);
        }
    }

    public void insertarIesimo(int x, int i) {
        int k = 0;
        Nodo p = prim, ap = null;
        while (p != null && k < i) {
            ap = p;
            p = p.prox;
            k++;
        }
        insertarNodo(x, ap, p);
    }

    public void insertarNodo(int x, Nodo ap, Nodo p) {
        if (ap == null) {
            insertarPrim(x);
        } else {
            if (p == null) {
                insertarUlt(x);
            } else {
                ap.prox = new Nodo(x, p);
                cantElem++;
            }
        }
    }

    public boolean iguales() {
        Nodo p = prim;
        while (p != null && p.prox != null) {
            if (p.elem == p.prox.elem) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    public int menorElem() {
        Nodo p = prim;
        int menor = p.elem;
        while (p != null) {
            if (p.elem < menor) {
                menor = p.elem;
            }
            p = p.prox;
        }
        return menor;
    }

    public void reemplazar(int x, int y) {
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                p.elem = y;
            }
            p = p.prox;
        }
    }

    public boolean seEncuentra(int x) {
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    public int frecuencia(int x) {
        Nodo p = prim;
        int fre = 0;
        while (p != null) {
            if (p.elem == x) {
                fre++;
            }
            p = p.prox;
        }
        return fre;
    }

    public void insertarUlt(ListaEnlazada l2) {
        Nodo p = l2.prim;
        while (p != null) {
            insertarUlt(p.elem);
            p = p.prox;
        }
    }

    public void insertarLugar(int x) {
        Nodo p = prim;
        Nodo ap = null;
        while (p != null && p.elem < x) {
            ap = p;
            p = p.prox;
        }
        if (ap == null) {
            insertarPrim(x);
        } else {
            ap.prox = new Nodo(x, p);
            if (p == null) {
                ult = ap.prox;
            }
            cantElem++;
        }
    }

    //TAREA4 --> ejercicios basicos sobre listas encadenadas simples
    public boolean diferentes() {
        Nodo p = prim;
        while (p != null && p.prox != null) {
            if (p.elem != p.prox.elem) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    public int mayorElem() {
        Nodo p = prim;
        int mayor = p.elem;
        while (p != null) {
            if (p.elem > mayor) {
                mayor = p.elem;
            }
            p = p.prox;
        }
        return mayor;
    }

    //8.      L1.ordenado()  : Método Lógico que devuelve True,
    // si todos los elementos de la lista L1 están ordenados en forma ascendente o descendente.
    public boolean ordenado() {
        if (prim == null || prim.prox == null) {
            return true; // una lista vacía o con un solo elemento se considera ordenada
        }
        Nodo p = prim;
        boolean asc = p.prox.elem >= p.elem;
        boolean desc = p.prox.elem <= p.elem;
        p = p.prox;
        while (p.prox != null) {
            if (asc && p.prox.elem < p.elem) {
                return false;
            }
            if (desc && p.prox.elem > p.elem) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    //.      L1.pares() : Método lógico que devuelve True,
    // si todos los elementos de la lista L1 son pares.
    public boolean pares() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 != 0) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    //10.      L1.parImpar() : Método lógico que devuelve True,
    // si la lista L1 contiene al menos un elemento par e impar.
    public boolean parImpar() {
        Nodo p = prim;
        boolean encontradoPar = false, encontradoImpar = false;
        while (p != null) {
            if (p.elem % 2 == 0){
                encontradoPar = true;
            }else{
                encontradoImpar = true;
            }
            if (encontradoPar && encontradoImpar){
                return true;
            }
            p = p.prox;
        }
        return false;
    }

}
