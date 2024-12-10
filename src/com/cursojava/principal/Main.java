package com.cursojava.principal;

import com.cursojava.clases.Camion;
import com.cursojava.clases.Coche;
import com.cursojava.clases.Color;

public class Main {

	public static void main(String[] args) {
		Coche coche1 = new Coche("1753 KOW", Color.ROJO);
		System.out.println(coche1);
		
		coche1.arrancar();
		coche1.avanzar(12, 7);
		coche1.avanzar(150, 20);
		coche1.retroceder(10, 1);
		coche1.parar();
		System.out.println("Tiempo de viaje total de coche 1: "
				+ coche1.getTiempoViaje());
		System.out.println("Velocidad media de coche 1: "
				+ coche1.getVelocidadMedia());
		System.out.println("=====================================");
		
		Camion camion1 = new Camion("4148 WDI", Color.NEGRO);
		System.out.println(camion1);
		
		camion1.arrancar();
		camion1.avanzar(60, 15);
		camion1.avanzar(300, 30);
		camion1.avanzar(10, 2);
		camion1.parar();
		System.out.println("Tiempo de viaje total de camión 1: "
				+ camion1.getTiempoViaje());
		System.out.println("Tacómetro del camión 1: "+camion1.getTacometro());
		System.out.println("Velocidad media de camión 1: " 
				+ camion1.getVelocidadMedia());

	}

}
