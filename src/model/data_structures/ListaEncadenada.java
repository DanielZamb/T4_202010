package model.data_structures;

public class ListaEncadenada {
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private int tamanio;
    private Nodo actual;
    public ListaEncadenada(Nodo primerNodo){
        this.primerNodo = primerNodo;
        this.tamanio = 0;
        ultimoNodo = primerNodo;
        actual = null;
        darTamañoLista();
    }
    public int getTamanio(){
        return tamanio;
    }

    public Nodo getPrimerNodo() {
        return primerNodo;
    }

    public Nodo getUltimoNodo() {
        return ultimoNodo;
    }

    public void setPrimerNodo(Nodo primerNodo) {
        this.primerNodo = primerNodo;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void setUltimoNodo(Nodo ultimoNodo) {
        this.ultimoNodo = ultimoNodo;
    }

    public void darTamañoLista(){
        if (primerNodo!=null){
            Nodo evaluado = primerNodo;
            while (evaluado != null){
                tamanio++;
                evaluado = evaluado.getSiguiente();
            }
        }
    }
    public void appendNode(Nodo nuevo){
        nuevo.setSiguiente(primerNodo);
        primerNodo = nuevo;
        darTamañoLista();
    }
    public Nodo ConsultarNodo(int pos){
        Nodo buscado = null;
        if (pos==tamanio-1) buscado = ultimoNodo;
        else{
            int iterador = 0;
            Nodo evaluado = primerNodo;
            boolean encontro = false;
            while(evaluado != null && !encontro){
                encontro = (iterador == pos)? true :false;
                if (encontro) buscado = evaluado;
                else iterador++;
            }
        }
        return buscado;
    }
    public void deleteNode(int pos){
        Nodo anterior = ConsultarNodo(pos-1);
        if (pos == tamanio-1) {
            anterior.setSiguiente(null);
        } else if (pos == 0){
            primerNodo.setSiguiente(null);
        } else {
        Nodo aBorrar = ConsultarNodo(pos);
        anterior.setSiguiente(aBorrar.getSiguiente());
        aBorrar.setSiguiente(null);
        }
        darTamañoLista();
    }
    public void iniciarRecorrido(Nodo primero){
        ListaEncadenada lst = new ListaEncadenada(primero);
        lst.setUltimoNodo(ConsultarNodo(lst.tamanio-1));

    }

}
