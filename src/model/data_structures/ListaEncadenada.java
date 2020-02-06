package model.data_structures;

public class ListaEncadenada<T>{
    private Nodo<T> primerNodo;
    private Nodo<T> ultimoNodo;
    private Nodo<T> primeroAntiguo;
    private int tamanio;
    private Nodo<T> actual;
    private IteratorLista iter;
    public ListaEncadenada(Nodo<T> primerNodo){
        this.primerNodo = primerNodo;
        primeroAntiguo = primerNodo;
        this.tamanio = 0;
        ultimoNodo = primerNodo;
        actual = null;
        iter = null;
        darTamañoLista();
    }
    public void Iterador(String ControlS,Nodo<T> primeroPersonal) throws Exception {
        iter = new IteratorLista(this,ControlS,primeroPersonal);
    }
    public Nodo<T> consultarActual() {
        return actual;
    }
    public void setActual(Nodo<T> actual) {
        this.actual = actual;
    }

    public int getTamanio(){
        return tamanio;
    }

    public Nodo<T> getPrimerNodo() {
        return primerNodo;
    }

    public Nodo<T> getUltimoNodo() {
        return ultimoNodo;
    }

    public void setPrimerNodo(Nodo<T> primerNodo) {
        this.primerNodo = primerNodo;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void setUltimoNodo(Nodo<T> ultimoNodo) {
        this.ultimoNodo = ultimoNodo;
    }

    public Nodo<T> getPrimeroAntiguo() {
        return primeroAntiguo;
    }

    public void darTamañoLista(){
        if (primerNodo!=null){
            Nodo<T> evaluado = primerNodo;
            while (evaluado != null){
                tamanio++;
                evaluado = evaluado.getSiguiente();
            }
        }
    }
    public void AppendNode(Nodo<T> nuevo){
        nuevo.setSiguiente(primerNodo);
        primerNodo = nuevo;
        primeroAntiguo = primerNodo;
        darTamañoLista();
    }
    public void appendNodeInPos(Nodo<T> nuevo, int pos){

    }
    public Nodo<T> ConsultarNodo(int pos){
        Nodo<T> buscado = null;
        if (pos==tamanio-1) buscado = ultimoNodo;
        else{
            int iterador = 0;
            Nodo<T> evaluado = primerNodo;
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
        Nodo<T> anterior = ConsultarNodo(pos-1);
        if (pos == tamanio-1) {
            anterior.setSiguiente(null);
            ultimoNodo = anterior;
        } else if (pos == 0){
            Nodo<T> siguiente = primerNodo.getSiguiente();
            primerNodo.setSiguiente(null);
            primerNodo = siguiente;
            primeroAntiguo = primerNodo;
        } else {
            Nodo<T> aBorrar = ConsultarNodo(pos);
            anterior.setSiguiente(aBorrar.getSiguiente());
            aBorrar.setSiguiente(null);
        }
        darTamañoLista();
    }

}
