package model.data_structures;

public class ListaEncadenada {
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private Nodo primeroAntiguo;
    private int tamanio;
    private Nodo actual;
    private IteratorLista iter;
    public ListaEncadenada(Nodo primerNodo){
        this.primerNodo = primerNodo;
        primeroAntiguo = primerNodo;
        this.tamanio = 0;
        ultimoNodo = primerNodo;
        actual = null;
        iter = null;
        darTamañoLista();
    }
    public void Iterador(String ControlS,Nodo primeroPersonal) throws Exception {
        iter = new IteratorLista(this,ControlS,primeroPersonal);
    }
    public Nodo consultarActual() {
        return actual;
    }
    public void setActual(Nodo actual) {
        this.actual = actual;
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

    public Nodo getPrimeroAntiguo() {
        return primeroAntiguo;
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
    public void AppendNode(Nodo nuevo){
        nuevo.setSiguiente(primerNodo);
        primerNodo = nuevo;
        primeroAntiguo = primerNodo;
        darTamañoLista();
    }
    public void appendNodeInPos(Nodo nuevo, int pos){

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
            ultimoNodo = anterior;
        } else if (pos == 0){
            Nodo siguiente = primerNodo.getSiguiente();
            primerNodo.setSiguiente(null);
            primerNodo = siguiente;
            primeroAntiguo = primerNodo;
        } else {
            Nodo aBorrar = ConsultarNodo(pos);
            anterior.setSiguiente(aBorrar.getSiguiente());
            aBorrar.setSiguiente(null);
        }
        darTamañoLista();
    }

}
