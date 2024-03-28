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
}
