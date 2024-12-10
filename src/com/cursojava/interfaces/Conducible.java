package com.cursojava.interfaces;
/** 
 * Interfaz implementada solo por las clases de vehiculos que puedan ser 
 * conducibles.
 * @author Francisco Manuel Villalobos
 * @version 1.0 10/12/2024
 */
public interface Conducible {
	/**
	 * Se empieza a contar el tramo que va a recorrer el vehículo conducible.
	 */
	void arrancar();
	
	/**
	 * @param distancia Los metros que avanza el vehículo conducible.
	 * @param segundos Los segundos que tarda en avanzar la distancia indicada.
	 */
	void avanzar(double metros, long segundos); //Indica los metros que avanza y durante cuantos segundos
	
	/**
	 * @param distancia Los metros que retrocede el vehículo conducible.
	 * @param segundos Los segundos que tarda en retroceder la distancia indicada.
	 */
	void retroceder(double metros, long segundos); //Indica los metros que avanza y durante cuantos segundos
	
	/**
	 * Termina de contar el tramo que ha recorrido el vehículo conducible.
	 */
	void parar();
	
	/**
	 * @return Tiempo total de viaje en segundos
	 */
	long getTiempoViaje();
	
	/**
	 * @return velocidad media en metros por segundo
	 */
	double getVelocidadMedia();

}
