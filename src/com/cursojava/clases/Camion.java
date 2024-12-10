package com.cursojava.clases;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.cursojava.interfaces.Conducible;
/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 10/12/2024
 */
public final class Camion extends Vehiculo implements Conducible {

	private static final int NUMERO_RUEDAS = 6;
	
	private List<Double> tacometro;
	private double espacioRecorrido;
	private boolean enMarcha;
	private LocalTime tiempoInicio;
	private LocalTime tiempoActual;
	private LocalTime tiempoFin;
	
	public Camion(String matricula, Color color) {
		super(NUMERO_RUEDAS, matricula, color);
		this.tacometro = new ArrayList<>();
		this.espacioRecorrido = 0.;
		this.enMarcha = false;
	}
	
	public List<Double> getTacometro() {
		return tacometro;
	}

	@Override
	public String toString() {
		return "Camion con matrícula: "+matricula+". Color: "+color;
	}

	@Override
	public void arrancar() {
		if (enMarcha) {
			System.out.println("El camión ya está en marcha.");
		} else {
			reiniciarDatos();
			tiempoInicio = LocalTime.now();
			enMarcha = true;
			System.out.println("Camión puesto en marcha. Tiempo inicial del viaje: "
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
		tacometro.clear();
		
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
			System.out.println("El camión no está en marcha. Debe arrancar primero.");
		} else if (metros < 0 | segundos < 0){
			System.out.println("No se puede avanzar una distancia negativa o tiempo negativo.");
		} else {
			espacioRecorrido += metros;
			tiempoActual = tiempoActual.plusSeconds(segundos);
			double velocidadTramo = (double) metros/segundos;
			tacometro.add(velocidadTramo);
			System.out.println("El camión ha avanzado "+metros+" metros en "
					+ segundos+" segundos. Se ha añadido la velocidad alcanzada"
					+ " en el tacómetro. Lleva recorridos "+espacioRecorrido
					+ " metros. Tiempo actual de viaje: "+tiempoActual);
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
			System.out.println("El camión no está en marcha. Debe arrancar primero.");
		} else if (metros < 0){
			System.out.println("No se puede retroceder una distancia negativa.");
		} else {
			if (metros > espacioRecorrido) {
				System.out.println("No se puede retroceder más de lo avanzado.");
			} else {
				espacioRecorrido -= metros;
				tiempoActual = tiempoActual.plusSeconds(segundos);
				double velocidadTramo = (double) metros/segundos;
				tacometro.add(velocidadTramo);
				System.out.println("El camión ha retrocedido "+metros+
						" metros en "+segundos+" segundos. Se ha añadido "
						+ "la velocidad alcanzada en el tacómetro. Lleva"
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
			System.out.println("El camión ya está detenido.");
		} else {
			tiempoFin = tiempoActual;
			enMarcha = false;
			System.out.println("Camión detenido. Tiempo final del viaje: "
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
	 * Devuelve la velocidad media del viaje (en metros por segundo) realizado mediante las velocidades
	 * registradas en el tacómetro
	 */
	@Override
	public double getVelocidadMedia() {
		double suma = 0;
		double res = 0;
		for(double vel: tacometro) {
			suma += vel;
		}
		res = (double) suma/tacometro.size();
		return res;
	}

}
