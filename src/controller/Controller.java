package controller;

import model.logic.*;
import model.data_structures.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import com.google.gson.*;

import model.logic.Comparendos;
import model.logic.Features;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	

	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() throws IOException 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();
			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage("Loading...");
				try {
					Gson gson = new Gson();
					String json = "./data/comparendos_dei_2018_BIG.geojson";
					BufferedReader br;
					br = new BufferedReader(new FileReader(json));
					Comparendos comparendos = gson.fromJson(br, Comparendos.class);
					Modelo<Features> mdl = new Modelo(comparendos.darListaFeatures());
					modelo = mdl;
					br.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    view.printMessage("Datos Cargados.");
			    view.printMessage("Primer comparendo del arreglo: " + modelo.getPrimerComparendo().toString() + "\n-----------------------------");
			    view.printMessage("Ultimo comparendo del arreglo: "+ modelo.getUltimoComparendo().toString()+"\n-----------------------------");
				break;
				case 2:
					view.printMessage("Loading...");
					modelo.copiarComparendos();
					view.printMessage("Arreglo Comparable[] creado");
					view.printMessage("Tamaño del arreglo creado:" + modelo.getTamanio()+" comparendos");
					break;
				case 3:
					view.printMessage("Sorting started");
					view.printMessage("Loading...");
					Features[] ordenado_S = modelo.ordenarShellSort(modelo.getCopia());
					view.printMessage("Arreglo ordenado");
					for (int i=0 ;i< ordenado_S.length-1;i++){
						view.printMessage(ordenado_S[i].toString());
						if (i == 10) view.printMessage("----------------------------------");
					}
					break;
				case 4:
					view.printMessage("Sorting started");
					view.printMessage("Loading...");
					Features[] ordenado_M = modelo.ordenarMergeSort(modelo.getCopia());
					view.printMessage("Arreglo ordenado");
					for (int i=0 ;i < ordenado_M.length-1;i++){
						view.printMessage(ordenado_M[i].toString());
						if (i == 10) view.printMessage("----------------------------------");
					}
					break;
				case 5:
					view.printMessage("Sorting started");
					view.printMessage("Loading...");
					Features[] ordenado_Q = modelo.ordenarQuickSort(modelo.getCopia());
					view.printMessage("Arreglo ordenado");
					for (int i=0 ;i < ordenado_Q.length-1;i++){
						view.printMessage(ordenado_Q[i].toString());
						if (i == 10) view.printMessage("----------------------------------");
					}
					break;
			}
		}
		
	}	
}
