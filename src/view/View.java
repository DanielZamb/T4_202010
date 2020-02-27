package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1.Cargar Datos");
			System.out.println("2.Crear arreglo \"Comparable[]\"");
			System.out.println("3.Ordenar ascendentemente el arreglo usando ShellSort");
			System.out.println("4.Ordenar ascendentemente el arreglo usando MergeSort");
			System.out.println("5.Ordenar ascendentemente el arreglo usando QuickSort");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
		}
}
