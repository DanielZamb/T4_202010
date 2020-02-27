package model.logic;

import model.data_structures.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Definicion del modelo del mundo
 *
 */
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
