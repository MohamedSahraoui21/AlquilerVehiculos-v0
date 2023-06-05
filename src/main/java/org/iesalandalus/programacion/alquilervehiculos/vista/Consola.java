package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

   public class Consola {

	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private Consola() {

	}

	public static void mostrarCabecera(String dev) {
		System.out.println(dev);
		for (int i = 0; i < dev.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void mostrarMenu() {
		String mensajePrimero = "Gestión de alquiler de vehículos:";
		System.out.println(mensajePrimero);
		for (Opcion opcion : Opcion.values()) {
			System.out.println(opcion);
		}
	}

	private static String leerCadena(String dev) {
		System.out.print(dev);
		String num = Entrada.cadena();
		return num;
	}

	private static Integer leerEntero(String dev) {
		System.out.print(dev);
		int num = Entrada.entero();
		return num;
	}

	private static LocalDate leerFecha(String dev) {
		LocalDate fecha = null;
		System.out.print(dev);
		try {
			fecha = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
		} catch (DateTimeException e) {
			System.out.println(e.getMessage());
		}
		return fecha;
	}

	public static Opcion elegirOpcion() {
		Opcion opcion = null;
		int opc;
		do {
			opc = leerEntero("elige una opción : ");

			try {
				opcion = Opcion.get(opc);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());

			}
		} while (opc < 0 || opc >= Opcion.values().length);
		return opcion;
	}

	public static Cliente leerCliente() {
		String nombre = leerCadena("escribe el nombre:");
		String dni = leerCadena("escribe el dni:");
		String telefono = leerCadena("escribe el telefono:");
		return new Cliente(nombre, dni, telefono);
	}

	public static Cliente leerClienteDni() {
		String dni = leerCadena("escribe el dni:");
		Cliente cliente = Cliente.getClienteConDni(dni);
		return cliente;
	}

	public static String leerNombre() {
		String nombre = leerCadena("escribe el nombre:");
		return nombre;
	}

	public static String leerTelefono() {
		String telefono = leerCadena("escribe el telefono:");
		return telefono;
	}

	public static Turismo leerTurismo() {
		String marca = leerCadena("escribe la marca:");
		String modelo = leerCadena("escribe el modelo:");
		int cilindrada = leerEntero("escribe la cilindrada:");
		String matricula = leerCadena("escribe la matricula:");
		return new Turismo(marca, modelo, cilindrada, matricula);
	}

	public static Turismo leerTurismoMatricula() {
		String matricula = leerCadena("escribe la matricula:");
		Turismo turismo = Turismo.getTurismoConMatricula(matricula);
		return turismo;
	}

	public static Alquiler leerAlquiler() {
		Cliente cliente = leerClienteDni();
		Turismo turismo = leerTurismoMatricula();
		LocalDate fechaAlquiler = leerFecha("escribe la fecha de Alquiler:");
		return new Alquiler(cliente, turismo, fechaAlquiler);
	}

	public static LocalDate leerFechaDevolucion() {
		LocalDate fechaDevolucion = leerFecha("escribe la fecha de Devolucion:");
		return fechaDevolucion;
	}

}
