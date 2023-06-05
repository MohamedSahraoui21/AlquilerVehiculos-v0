package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public class Vista {

	private Controlador controlador;

	public void setControlador(Controlador controlador) {
		if (controlador == null) {
			throw new NullPointerException("El controlador no puede ser nulo");
		}
		this.controlador = controlador;
	}

	public void comenzar() {
		Opcion opcion;
		do {
			Consola.mostrarMenu();
			opcion = Consola.elegirOpcion();
			ejecutar(opcion);
			System.out.println("");
		} while (opcion != Opcion.SALIR);
	}

	public void terminar() {
		System.out.print("gracias, hasta luego.");
		System.exit(0);
	}

	private void ejecutar(Opcion opcion) {
		switch (opcion.ordinal()) {
		case 0:
			terminar();
			break;
		case 1:
			insertarCliente();
			break;
		case 2:
			insertarTurismo();
			break;
		case 3:
			insertarAlquiler();

			break;
		case 4:
			buscarCliente();

			break;
		case 5:
			buscarTurismo();

			break;
		case 6:
			buscarAlquiler();

			break;
		case 7:
			modificarCliente();

			break;
		case 8:
			devolverAlquiler();

			break;
		case 9:
			borrarCliente();

			break;
		case 10:
			borrarTurismo();

			break;
		case 11:
			borrarAlquiler();

			break;
		case 12:
			listarClientes();

			break;
		case 13:
			listarTurismos();

			break;
		case 14:
			listarAlquileres();

			break;
		case 15:
			listarAlquileresCliente();

			break;
		case 16:
			listarAlquileresTurismo();

			break;
		}
	}

	private void insertarCliente() {
		try {
			Consola.mostrarCabecera("  1-Insertar Cliente");
			controlador.insertar(Consola.leerCliente());
			System.out.print("el cliente se ha insertado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void insertarTurismo() {
		try {
			Consola.mostrarCabecera(" 2-Insertar Turismo");
			controlador.insertar(Consola.leerTurismo());
			System.out.print("el turismo se ha insertado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void insertarAlquiler() {
		try {
			Consola.mostrarCabecera(" 3-Insertar Alquiler");
			controlador.insertar(Consola.leerAlquiler());
			System.out.print("el Alquiler se ha insertado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void buscarCliente() {
		try {
			Consola.mostrarCabecera(" 4-Buscar Cliente");
			System.out.print(controlador.buscar(Consola.leerClienteDni()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void buscarTurismo() {
		try {
			Consola.mostrarCabecera(" 5-Buscar Turismo");
			System.out.print(controlador.buscar(Consola.leerTurismoMatricula()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}

	}

	private void buscarAlquiler() {
		try {
			Consola.mostrarCabecera(" 6-Buscar Alquiler");
			System.out.print(controlador.buscar(Consola.leerAlquiler()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void modificarCliente() {
		try {
			Consola.mostrarCabecera(" 7-Modificar Cliente");
			controlador.modificar(Consola.leerClienteDni(), Consola.leerNombre(), Consola.leerTelefono());
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void devolverAlquiler() {
		try {
			Consola.mostrarCabecera(" 8-Devolver Alquiler");
			controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void borrarCliente() {
		try {
			Consola.mostrarCabecera(" 9-Borrar Cliente");
			controlador.borrar(Consola.leerClienteDni());
			System.out.print("este cliente se ha borrado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void borrarTurismo() {
		try {
			Consola.mostrarCabecera(" 10-Borrar Turismo");
			controlador.borrar(Consola.leerTurismoMatricula());
			System.out.print("este turismo se ha borrado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void borrarAlquiler() {
		try {
			Consola.mostrarCabecera(" 11-Borrar Alquiler");
			controlador.borrar(Consola.leerAlquiler());
			System.out.print("este Alquiler se ha borrado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void listarClientes() {
		Consola.mostrarCabecera(" 12-Listar Clientes");
		System.out.print(controlador.getClientes());
	}

	private void listarTurismos() {
		Consola.mostrarCabecera(" 13-Listar Turismos");
		System.out.println(controlador.getTurismos());
	}

	private void listarAlquileres() {
		Consola.mostrarCabecera(" 14-Listar Alquileres");
		System.out.println(controlador.getAlquileres());
	}

	private void listarAlquileresCliente() {

		try {
			Consola.mostrarCabecera(" 15-Listar los Alquileres de un Cliente");
			System.out.println(controlador.getAlquileres(Consola.leerClienteDni()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void listarAlquileresTurismo() {
		try {
			Consola.mostrarCabecera(" 16-Listar los Alquileres de un Turismo");
			System.out.println(controlador.getAlquileres(Consola.leerTurismoMatricula()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

}
