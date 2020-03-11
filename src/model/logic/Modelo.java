package model.logic;

import model.data_structures.*;
<<<<<<< HEAD

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
=======
import java.util.List;
import java.util.concurrent.TimeUnit;
>>>>>>> master

/**
 * Definicion del modelo del mundo
 *
 */
<<<<<<< HEAD
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
=======
public class Modelo<S extends Comparable <S>> {// ,S extends Comparable<S>
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico<S> arregloD;
	private int tamanio;
	private Comparable[] copia;
	private Features primerComparendo;
	private Features ultimoComparendo;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo() {
		arregloD = null;
		tamanio = 0;
		primerComparendo = null;
		ultimoComparendo = null;
	}

	public Modelo(List<S> listaFeatures) {
		cargarComparendos(listaFeatures);

	}

	public void cargarComparendos(List<S> listaFeatures) {
		try {
			long startTime = System.nanoTime();
			arregloD = new ArregloDinamico<Features>(listaFeatures.size());
			listaFeatures.forEach(feature -> {
				arregloD.agregar((S) feature);
			});
			primerComparendo = (Features) listaFeatures.get(0);
			ultimoComparendo = (Features) listaFeatures.get(listaFeatures.size()-1);
			tamanio = arregloD.darTamano();
			long endTime = System.nanoTime();
			long elapsedTime = endTime - startTime;
			double convertET = (double) elapsedTime / 1000000000;
			System.out.println("tamaño del arreglo: " + arregloD.darTamano());
			System.out.println("Time elapsed loading data: " + convertET + " seconds");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Features getPrimerComparendo() {
		return primerComparendo;
	}

	public Features getUltimoComparendo() {
		return ultimoComparendo;
	}

	public int getTamanio() {
		return tamanio;
	}

	public Comparable[] copiarComparendos() {
		Features[] nuevo = new Features[arregloD.darTamano()];
		for (int i=0;i<arregloD.darTamano();i++){
			nuevo[i] = (Features) arregloD.darElemento(i);
		}
		tamanio = nuevo.length;
		copia = nuevo;
		return nuevo;
	}
	public Features[] ordenarShellSort(Comparable[] list){
		long startTime = System.currentTimeMillis();
		Shell.sort(list);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("Time elapsed ShellSorting the array: "+elapsedTime+" miliseconds");
		return comparendosOrdenados(list);
>>>>>>> master
	}
	public Features[] ordenarMergeSort(Comparable[] list){
		long startTime = System.currentTimeMillis();
		Merge.sort(list);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("Time elapsed MergeSorting the array: "+elapsedTime+" miliseconds");
		return comparendosOrdenados(list);

	}
	public Features[] ordenarQuickSort(Comparable[] list){
		long starTime =System.currentTimeMillis();
		Quick.sort(list);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - starTime;
		System.out.println("Time elapsed QuickSorting the array: "+elapsedTime+" miliseconds");
		return comparendosOrdenados(list);

	}
	public Comparable[] getCopia(){
		return copia;
	}

	private Features[] comparendosOrdenados(Comparable[] list){
		int k = 0;
		Features[] comparendos_ = new Features[20];
		for(int i=0;i<10;i++){
			comparendos_[i] = (Features) list[i];
		}
		for (int j=list.length-11;j<=list.length-1;j++){
			if (list[j] == null) j++;
			comparendos_[9+k] = (Features) list[j];
			k++;
		}
		return comparendos_;
	}


}
