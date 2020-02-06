package model.logic;

import model.data_structures.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo<T> {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;
	private ListaEncadenada listaComparendos;
	private Nodo<T> nodoComparendo;
	private ArrayList<T> comparendorArr;
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo(){
	}
	public Modelo(List<T> comparendosJson)
	{
		cargarComparendos(comparendosJson);
	}
	public void cargarComparendos(List<T> comparendosJson){
		nodoComparendo = (Nodo<T>) comparendosJson.get(0);
		System.out.println(nodoComparendo);

	}

	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{
		datos.agregar(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato)
	{
		return datos.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return datos.eliminar(dato);
	}



}
