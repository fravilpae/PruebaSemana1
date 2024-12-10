package com.cursojava.clases;
/**
 * Clase abstracta de la que heredarán todos los tipos de vehículos
 * @author Francisco Manuel Villalobos
 * @version 1.0 10/12/2024
 */
public abstract class Vehiculo {

	protected final int ruedas;
	protected final String matricula;
	protected Color color;
	
	public Vehiculo(int ruedas, String matricula, Color color) {
		super();
		this.ruedas = ruedas;
		this.matricula = matricula;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getRuedas() {
		return ruedas;
	}

	public String getMatricula() {
		return matricula;
	}
}
