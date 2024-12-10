# Proyecto Vehiculo conducible

Este es un proyecto Java que define varias clases de vehículos, que heredan de la superclase Vehiculo. A su vez, los vehículos que puedan ser conducidos tendrán implementada la interfaz Conducible.

Para utilizar este proyecto no requiere instalación previa.

## Descripción
La clase Vehiculo representa a todos los tipos de vehículos y se utiliza para como superclase para los distintos tipos de vehículo existentes en el proyecto. Esta clase contiene información sobre el color, la matrícula y el número de
ruedas del vehículo.

La clase Coche hereda de Vehiculo, y se utiliza para instanciar objetos con información sobre color, y matrícula de coche. Al implementar conducible, tiene métodos para arrancar, avanzar, retroceder y parar el coche, además de obtener el tiempo de un viaje realizado y la velocidad media de ese viaje.

La clase Camion hereda de Vehiculo, y se utiliza para instanciar objetos con información sobre color, matrícula y tacómetro de camion. Al implementar conducible, tiene métodos para arrancar, avanzar, retroceder y parar el coche, además de obtener el tiempo de un viaje realizado y la velocidad media de ese viaje.

Todos las clases que implementen Conducible tendrán una serie de atributos específicos. Estos son:
- tiempoInicio: Tiempo inicial del recorrido.
- tiempoFin: Tiempo final del recorrido.
- tiempoActual: Tiempo actual del recorrido.
- espacioRecorrido: Espacio recorrido por el vehículo.
- enMarcha: Booleano que indica si el vehículo está arrancado o no.

## Funcionalidades
**Clase Vehiculo**

La clase Vehiculo tiene las siguientes funcionalidades:

Constructor: Crea una instancia de vehiculo con un color, matrícula y número de ruedas.

getColor(): Devuelve el color del vehículo.

setColor(Color color): Modifica el color del vehículo.

getRuedas(): Devuelve el número de ruedas del vehículo.

getMatricula(): Devuelve la matrícula del vehículo.

**Clase Camion**

La clase Camion tiene una funcionalidad única:

getTacometro(): Devuelve la lista del tacómetro del camión.

**Clases Camion y Coche**

Las clases Coche y Camion tienen las siguientes funcionalidades:

Constructor: Crea una instancia de Coche o Camion con un color, matrícula y número de ruedas determinado por la clase.

arrancar(): Arranca Camion o Coche y establece la hora de inicio del viaje. Si ya estaba en marcha, muestra un mensaje de aviso.

reiniciarDatos(): Método privado de cada clase que sirve para reiniciar los estados de tiempo y espacio, para que los recorridos se guarden correctamente. 

avanzar(double metros, long segundos): Avanza Camion o Coche la cantidad de metros indicada durante la cantidad de segundos indicada. Si el vehiculo no está en marcha o los parámetros son negativos, muestra un mensaje de aviso.

retroceder(double metros, long segundos): Retrocede Camion o Coche la cantidad de metros indicada durante la cantidad de segundos indicada. Si el vehiculo no está en marcha, los párametros son negativos, o los metros indicados sobrepasan el actual espacio recorrido del vehículo, muestra un mensaje de aviso. 

parar(): Detiene Camion o Coche y muestra la hora final del viaje. Si el vehiculo no está en marcha, muestra un mensaje de aviso.

getTiempoViaje(): Devuelve la duración del viaje realizado, desde que se arranca el vehículo hasta que se detiene. Si no se ha realizado un viaje completo (arrancar y parar), devuelve 0.

getVelocidadMedia(): Devuelve la velocidad media durante el viaje realizado.

Todos los métodos en común salvo reiniciarDatos() se encuentran en la interfaz Conducible.

## Uso
**Uso de la clase Coche**

Para utilizar la clase, primero debe instanciar un objeto Coche pasando los argumentos adecuados al constructor. Luego, puede llamar a los métodos arrancar(), avanzar(), retroceder(), parar(), getTiempoViaje() y getVelocidadMedia() según sea necesario.

**Uso de la clase Camion**

Para utilizar la clase, primero debe instanciar un objeto Camion pasando los argumentos adecuados al constructor. Luego, puede llamar a los métodos arrancar(), avanzar(), retroceder(), parar(), getTiempoViaje() y getVelocidadMedia() según sea necesario.

## Historia
Versión 1.0 (2024-12-10) - Lanzamiento inicial
