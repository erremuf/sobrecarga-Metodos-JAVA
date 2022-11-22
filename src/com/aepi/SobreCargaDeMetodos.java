package com.aepi;

import java.util.Scanner;

public class SobreCargaDeMetodos {

	public static void main(String[] args) {

		Empleado empleado = new Empleado("Ricardo", "Murillo", 30, 1200, 5);
		Empleado empleadoDos = new Empleado("Jesus", "García", 41, 2000, 10);
		Empleado empleadoTres = new Empleado("Andrés", "Caballero", 36, 3000, 12);
		

		System.out.println(empleado.nombre + " cobra " + empleado.plus(10) + ", " + empleadoDos.nombre + " cobra "
				+ empleadoDos.plus(20, empleadoDos.antiguedad) + ", " + empleadoTres.nombre + " cobra "
				+ empleadoTres.plus(20, empleadoTres.antiguedad));

		System.out.println("\n\nEl salario base de " + empleadoDos.nombre + " es igual a " + empleadoDos.salario
				+ "€, como lleva 10 años en la empresa le aplicamos una retencion del 10% que son "
				+ (empleadoDos.salario * 10 / 100) + "€, entonces cobraría \n"
				+ empleadoDos.plus(0, empleadoDos.antiguedad)
				+ " pero le vamos a sumar un plus de un 20%, por lo que su salario es de "
				+ empleadoDos.plus(20, empleadoDos.antiguedad) + "€");

		System.out.println("\n\nEl salario base de " + empleadoTres.nombre + " es igual a " + empleadoTres.salario
				+ "€, como lleva 12 años en la empresa le aplicamos una retencion del 15% que son "
				+ (empleadoTres.salario * 15 / 100) + "€, entonces cobraría \n"
				+ empleadoTres.plus(0, empleadoTres.antiguedad)
				+ " pero le vamos a sumar un plus de un 20%, por lo que su salario es de "
				+ empleadoTres.plus(20, empleadoTres.antiguedad) + "€");

	}

}

class Empleado {

	String nombre;
	String apellidos;
	int edad;
	double salario;
	int antiguedad;

	public Empleado() {
	}

	public Empleado(String nombre, String apellidos, int edad, double salario, int antiguedad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.salario = salario;
		this.antiguedad = antiguedad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	

	public double plus(double porcentaje) {
		double DineroPlus = (porcentaje * salario) / 100;
		double sueldoTotal;
		if (edad >= 40) {
			sueldoTotal = salario + DineroPlus;
			return sueldoTotal;
		} else {
			return salario;
		}
	}
	/*
	 * if(edad >= 40) {
	 * salario += (porcentaje * salario) / 100;
	 * } return salario;
	 */

	public double plus(double porcentaje, int antiguedad) {
		double dineroPlus = (porcentaje * salario) / 100;
		double retencionUno = (10 * salario) / 100;
		double retencionDos = (15 * salario) / 100;
		double sueldoTotal;
		if (antiguedad >= 5 && antiguedad <= 10) {
			sueldoTotal = salario + dineroPlus - retencionUno;
			return sueldoTotal;
		} else if (antiguedad >= 11 && antiguedad <= 19) {
			sueldoTotal = salario + dineroPlus - retencionDos;
			return sueldoTotal;
		} else {
			return salario + dineroPlus;
		}
	}

	/*
	 * public double plus(double porcentaje, int antiguedad) { 
	 * double sueldoTotal = 0.0;
	 * salario += (porcentaje*salario) / 100;
	 * if(antiguedad >= 5 && antiguedad <= 10) { 
	 * sueldoTotal = salario - (10 * salario) / 100;
	 * return sueldoTotal;
	 * }else if (antiguedad >= 11 && antiguedad <= 19) {
	 * sueldoTotal = salario - (10 * salario) / 100;
	 * }
	 * return sueldoTotal; }
	 */

	
	@Override
	public String toString() {
		return nombre + " " + apellidos + ", tiene " + edad + " años y cobra " + salario + "€."
				+ " Lleva en la empresa " + antiguedad + " años.";
	}

}