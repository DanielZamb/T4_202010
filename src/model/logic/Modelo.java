package model.logic;

import model.data_structures.*;

import java.lang.reflect.Type;
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
	private ListaEncadenada<T> listaComparendos;
	private Nodo<T> nodoComparendo;


	public Modelo(){
	}
	public Modelo(List<T> listaFeatures)
	{
		cargarComparendos(listaFeatures);
	}
	public void cargarComparendos(List<T> listaFeatures){
		try {
			Nodo<Features> primero = new Nodo<Features>(null, (Features) listaFeatures.get(0));
			listaFeatures.remove(0);
			listaComparendos = new ListaEncadenada<T>((Nodo<T>) primero);
			listaFeatures.forEach(feature -> {
				nodoComparendo = new Nodo<T>(null,(T) feature);
				listaComparendos.AppendNode(nodoComparendo);
				System.out.println(listaComparendos.getTamanio());
			});


		}catch (Exception e){e.printStackTrace();}
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
