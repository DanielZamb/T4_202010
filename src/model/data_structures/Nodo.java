package model.data_structures;

public class Nodo<T> {
    private Nodo siguiente;
    private T properties;
    private T geometry;

    public Nodo(Nodo siguiente, T properties, T geometry){
        this.siguiente = siguiente;
        this.properties = properties;
        this.geometry = geometry;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public T getProperties() {
        return properties;
    }

    public T getGeometry() {
        return geometry;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setProperties(T properties) {
        this.properties = properties;
    }

    public void setGeometry(T geometry) {
        this.geometry = geometry;
    }
}
