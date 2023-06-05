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
    //constructor por defecto que crea el arraylist
	public Alquileres() {

		coleccionAlquileres = new ArrayList<>();
	}

	public List<Alquiler> get() {
		return new ArrayList<Alquiler>(coleccionAlquileres);
	}
         //voy a utlizar un metodo de arraylist (.Add)
	public List<Alquiler> get(Cliente cliente) {

		List<Alquiler> alquileresCl = new ArrayList<Alquiler>();
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getCliente().equals(cliente)) {
				alquileresCl.add(alquiler);
			}
		}
		return alquileresCl;
	}

	public List<Alquiler> get(Turismo turismo) {

		List<Alquiler> alquileredTur = new ArrayList<Alquiler>();
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getTurismo().equals(turismo)) {
				alquileredTur.add(alquiler);
			}
		}
		return alquileredTur;
	}
     //voy a utlizar un metodo de arraylist (.size) para saber la cantidad de una lista
	public int getCantidad() {
		return coleccionAlquileres.size();
	}

	
	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler)
			throws OperationNotSupportedException {
		for (Alquiler alquiler : get()) {
			if (alquiler.getTurismo().equals(turismo)) {
				if (alquiler.getFechaDevolucion() == null) {
					throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
				}
				if (alquiler.getFechaDevolucion().isAfter(fechaAlquiler) || alquiler.getFechaDevolucion().isEqual(fechaAlquiler)) {
					throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
				}
			}
			// comprobar el alquiler si esta todavia sin devolver o posterior //

			if (alquiler.getCliente().equals(cliente)) {
				if (alquiler.getFechaDevolucion() == null) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
				}
				if (alquiler.getFechaDevolucion().isAfter(fechaAlquiler)|| alquiler.getFechaDevolucion().isEqual(fechaAlquiler)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
				}
			}
			
		}
	}

	// metodo insertar//
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}
		comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());
		coleccionAlquileres.add(alquiler);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		}
		if (buscar(alquiler) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
		alquiler.devolver(fechaDevolucion);
	}
   //voy a utilizar un metodo de arraylist (.remove) para borrar un elemento de la lista
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}
		if (!coleccionAlquileres.contains(alquiler)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
		coleccionAlquileres.remove(alquiler);
	}
       // voy a ultilizar un metodo de ArrayList para buscar un valor en la lista utilizar (.get())
	public Alquiler buscar(Alquiler alquiler) {
		Alquiler alquilerEncontrado;
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}
		int indice = coleccionAlquileres.indexOf(alquiler);
		if (coleccionAlquileres.contains(alquiler)) {
			alquilerEncontrado = coleccionAlquileres.get(indice);
		} else {
			alquilerEncontrado = null;
		}
		return alquilerEncontrado;
	}

}