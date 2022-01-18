/******************************************************************
Ultima modificacion: 17/01/2022

Clase main grupo 1
@file MainGrupo1.java

******************************************************************/
import java.util.Scanner;

public class MainGrupo1{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        RadioGrupo1 radio = new RadioGrupo1();
        
        String opcion = "0";
        //inicia el menu principal
        while (!opcion.equalsIgnoreCase("7")) {
        	System.out.println("Escriba el numero de la opcion que desee realizar:\n1. Encender la radio\n2. Cambiar de frecuencia\n3. Avanzar de emisora\n4. Guardar una emisora\n5. Seleccionar emisora puesta en un boton\n6. Apagar el radio\n7. Salir del programa\n\n");
        	opcion = scan.nextLine();
        	if (opcion.equalsIgnoreCase("1")) {
        		//Encender la radio
        		if (radio.isOn()) {
        		} else {
        			radio.turnOnOff();
        		}
        		System.out.println("Radio encendida\n");
        		
        	} else if (opcion.equalsIgnoreCase("2")) {
        		//Cambiar la frecuencia
        		if (radio.isOn()) {
        			radio.switchAMFM();
        			if (radio.getFrequency()) {
        				System.out.println("\nLa frecuencia se ha cambiado de FM a AM");
        			} else {
        				System.out.println("\nLa frecuencia se ha cambiado de AM a FM");
        			}
        		} else {
        			System.out.println("\nLa radio se encuentra apagada, no se puede cambiar de frecuencia");
        		}
        		
        	} else if (opcion.equalsIgnoreCase("3")) {
        		//Avanzar emisora
        		if (radio.isOn()) {
        			radio.nextStation(radio.getFrequency());
        			System.out.println("\nAhora se encuentra en la emisora "+radio.getStation());
        		} else {
        			System.out.println("\nLa radio se encuentra apagada, no se puede avanzar emisora");
        		}
        		
        	} else if (opcion.equalsIgnoreCase("4")) {
        		//Guardar emisora
        		if (radio.isOn()) {
        			System.out.println("\nIngrese el numero de boton en el que quiere guardar la emisora actual (un numero del 1 al 12)");
        			try {
        				int boton = scan.nextInt();
        				scan.nextLine();
        				if (0<boton&&12>=boton) {
        					radio.saveStation(boton-1, radio.getStation());
        					System.out.println("\nEmisora "+radio.getStation()+" guardada");
        				} else {
        					System.out.println("\nEl numero ingresado no es valido");
        				}
        				
        			} catch (Exception e) {
        				scan.nextLine();
        				System.out.println("\nOpcion ingresada invalida.");
        			}
        		} else {
        			System.out.println("\nLa radio se encuentra apagada, no se puede guardar emisora");
        		}
        		
        	} else if (opcion.equalsIgnoreCase("5")) {
        		//Seleccionar emisora de las guardadas
        		if (radio.isOn()) {
        			System.out.println("\nIngrese el numero de boton en el que se encuentra guardada la emisora (un numero del 1 al 12)");
        			try {
        				int boton = scan.nextInt();
        				scan.nextLine();
        				if (0<boton&&12>=boton) {
        					double estacion = radio.getSavedStation(boton-1);
        					System.out.println("\nEstacion "+ estacion+" seleccionada");
        				} else {
        					System.out.println("\nEl numero ingresado no es valido");
        				}
        				
        			} catch (Exception e) {
        				scan.nextLine();
        				System.out.println("\nOpcion ingresada invalida.");
        			}
        			
        			
        		} else {
        			System.out.println("\nLa radio se encuentra apagada, no se puede seleccionar emisora");
        		}
        		
        	} else if (opcion.equalsIgnoreCase("6")) {
        		//Apagar el Radio
        		if (!radio.isOn()) {
        		} else {
        			radio.turnOnOff();
        		}
        		System.out.println("Radio apagada\n");
        		
        	} else if (opcion.equalsIgnoreCase("7")) {
        		//salir
        		System.out.println("\nUsted ha salido del programa");
        	} else {
        		// opcion invalida
        		System.out.println("\nPor favor ingrese una opcion valida\n");
        	}
        }
        
    	
    	scan.close();
    }
}