package com.cursojava.clases;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import com.cursojava.interfaces.Conducible;
/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 10/12/2024
 */
public final class Coche extends Vehiculo implements Conducible {

	private static final int NUMERO_RUEDAS = 4;
	
	private double espacioRecorrido;
	private boolean enMarcha;
	private LocalTime tiempoInicio;
	private LocalTime tiempoActual;
	private LocalTime tiempoFin;
	
	public Coche(String matricula, Color color) {
		super(NUMERO_RUEDAS,matricula,color);
		this.espacioRecorrido = 0.;
		this.enMarcha = false;
	}
	
	@Override
	public String toString() {
		return "Coche con matrícula: "+matricula+ ". Color: "+color;
	}

	/**
	 * Método que arranca el vehículo cuando no está en marcha. Inicializa 
	 * el valor de tiempo de inicio del recorrido.
	 */
	@Override
	public void arrancar() {
		if (enMarcha) {
			System.out.println("El coche ya está en marcha.");
		} else {
			reiniciarDatos();
			tiempoInicio = LocalTime.now();
			enMarcha = true;
			System.out.println("Coche puesto en marcha. Tiempo inicial del viaje: "
					+ tiempoInicio);
		}

	}

	/**
	 * Método que reinicia los valores de tiempo y espacio, usado para que
	 * se reinicie cada vez que se arranque el vehículo.
	 */
	private void reiniciarDatos() {
		tiempoActual = LocalTime.now();
		tiempoFin = null;
		espacioRecorrido = 0;
		
	}

	/**
	 * Método que hace avanzar el coche.
	 * @param distancia Metros que avanza el vehículo
	 * @param segundos Segundos en recorrer la distancia indicada
	 * 
	 * Comprueba que el vehículo está en marcha y que la distancia y segundos
	 * indicados sean positivos. Añade la distancia al espacio recorrido del
	 * vehículo y guarda el tiempo después de recorrerlo.
	 */
	@Override
	public void avanzar(double metros, long segundos) {
		if (!enMarcha) {
			System.out.println("El coche no está en marcha. Debe arrancar primero.");
		} else if (metros < 0 | segundos < 0){
			System.out.println("No se puede avanzar una distancia negativa o tiempo negativo.");
		} else {
			espacioRecorrido += metros;
			tiempoActual = tiempoActual.plusSeconds(segundos);
			System.out.println("El coche ha avanzado "+metros+" metros en "
					+ segundos+" segundos. Lleva recorridos "
					+espacioRecorrido+" metros. Tiempo actual de viaje: "
					+tiempoActual);
		}

	}

	/**
	 * Método que hace retroceder el camión.
	 * @param distancia Metros que retrocede el vehículo
	 * @param segundos Segundos en recorrer la distancia indicada
	 * 
	 * Comprueba que el vehículo está en marcha, que la distancia y segundos
	 * indicados sean positivos y que la distancia no sobrepase el espacio
	 * recorrido. Disminuye la distancia al espacio recorrido del
	 * vehículo y guarda el tiempo después de recorrerlo.
	 */
	@Override
	public void retroceder(double metros, long segundos) {
		if (!enMarcha) {
			System.out.println("El coche no está en marcha. Debe arrancar primero.");
		} else if (metros < 0){
			System.out.println("No se puede retroceder una distancia negativa.");
		} else {
			if (metros > espacioRecorrido) {
				System.out.println("No se puede retroceder más de lo avanzado.");
			} else {
				espacioRecorrido -= metros;
				tiempoActual = tiempoActual.plusSeconds(segundos);
				System.out.println("El coche ha retrocedido "+metros+
						" metros en "+segundos+" segundos. Lleva"
						+ " recorridos "+espacioRecorrido+" metros. Tiempo actual"
								+ " de viaje: "+tiempoActual);
			}
		}

	}

	/**
	 * Método que detiene el vehículo cuando está en marcha. Guarda 
	 * el valor de tiempo final del recorrido.
	 */
	@Override
	public void parar() {
		if (!enMarcha) {
			System.out.println("El coche ya está detenido.");
		} else {
			tiempoFin = tiempoActual;
			enMarcha = false;
			System.out.println("Coche detenido. Tiempo final del viaje: "
					+ tiempoFin);
		}

	}
	
	/**
	 * Devuelve el tiempo total del viaje si este ha empezado y finalizado.
	 */
	@Override
	public long getTiempoViaje() {
		long res = (tiempoInicio == null | tiempoFin == null)?
				0 : ChronoUnit.SECONDS.between(tiempoInicio, tiempoFin);
		return res;
	}
	
	/**
	 * Devuelve la velocidad media del viaje realizado en metros por segundo
	 */
	@Override
	public double getVelocidadMedia() {
		double res = 0;
		long tiempoViaje = getTiempoViaje();
		res = (double) espacioRecorrido/tiempoViaje;
		return res;
	}

}
