package model.data_structures;

import java.util.Iterator;

public class IteratorLista {
    private String iteratorCS;
    private ListaEncadenada lst;
    private Nodo primero;

    public IteratorLista(ListaEncadenada lst, String iteratorCS, Nodo primero) throws Exception {
        this.lst = lst;
        this.iteratorCS = iteratorCS;
        this.primero = primero;
        Iterator(this.primero);
    }
    public void setIteratorCS(String iteratorCS) {
        this.iteratorCS = iteratorCS;
    }
    public void Iterator(Nodo primero)throws Exception{
        if (lst.getTamanio() > 1){
            if (iteratorCS.equals("iniciar")){
                lst.setPrimerNodo(primero);
                lst.setActual(lst.getPrimerNodo());
            } else if (iteratorCS.equals("finalizar") ){
                lst.setPrimerNodo(lst.getPrimeroAntiguo());
                lst.setActual(null);
            } else {
                throw new Exception("digite un secuencia de control valida \"iniciar\"/\"finalizar\"");
            }
        }
        else {
            throw new Exception("La lista solo contiene 1 nodo");
        }
    }
    public void IteratorNext()throws Exception{
        if (lst.consultarActual() != null){
            lst.setActual(lst.consultarActual().getSiguiente());
        }
        else {
            throw new Exception("debes incializar el iterador");
        }
    }
    public void IteratorPrevious()throws Exception{
        if (lst.consultarActual() != null){
            Nodo evaluado = lst.getPrimerNodo();
            boolean cent = false;
            while (evaluado != null && !cent){
                if (evaluado.getSiguiente().equals(lst.consultarActual())) {
                    lst.setActual(evaluado); 
                    cent = true;
                }
                else evaluado = evaluado.getSiguiente();
            }
        }
        else {
            throw new Exception("debes incializar el iterador");
        }
    }
}
