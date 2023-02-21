package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres {

	private List<Alquiler> coleccionAlquileres;

	public Alquileres() {
		
		coleccionAlquileres = new ArrayList<>();
	}

	
	public List<Alquiler> get() {
		return new ArrayList<Alquiler>(coleccionAlquileres);
	}

	public List<Alquiler> get(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}

		List<Alquiler> alquileresCliente = new ArrayList<Alquiler>();
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getCliente().equals(cliente)) {
				alquileresCliente.add(alquiler);
			}
		}
		return alquileresCliente;
	}

	public List<Alquiler> get(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}
		List<Alquiler> alquileresTurismo = new ArrayList<Alquiler>();
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getTurismo().equals(turismo)) {
				alquileresTurismo.add(alquiler);
			}
		}
		return alquileresTurismo;
	}

	public int getCantidad() {
		return coleccionAlquileres.size();
	}
    //comprobar el alquiler//
	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler)
			throws IllegalArgumentException, OperationNotSupportedException {
		for (Alquiler alquiler : get(cliente)) {

			if (alquiler.getFechaDevolucion() == null) {

				throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");

			}

			if (alquiler.getFechaDevolucion().isAfter(fechaAlquiler)

					|| alquiler.getFechaDevolucion().isEqual(fechaAlquiler)) {

				throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");

			}

		}

		for (Alquiler alquiler : get(turismo)) {

			if (alquiler.getFechaDevolucion() == null) {

				throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");

			}

			if ((alquiler.getFechaDevolucion().isAfter(fechaAlquiler)

					|| alquiler.getFechaDevolucion().isEqual(fechaAlquiler))) {

				throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");

			}
		}

	}
     //metodo insertar//
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}

		comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());
		coleccionAlquileres.add(alquiler);
	}
     //metodo buscar//
	public Alquiler buscar(Alquiler alquiler) {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}
		if (coleccionAlquileres.contains(alquiler)) {
			return alquiler;
		}
		return null;
	}
     //metodo borrar//
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}
		if (!coleccionAlquileres.contains(alquiler)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
		coleccionAlquileres.remove(alquiler);
	}
     //metodo devolver//
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		}
		if (!coleccionAlquileres.contains(alquiler)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");

		}
		alquiler.devolver(fechaDevolucion);

	}
}
