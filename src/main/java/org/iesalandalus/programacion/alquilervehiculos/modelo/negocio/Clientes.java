package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class Clientes {


	private List<Cliente> coleccionClientes;
    //constructor por defecto que crea el arraylist

	public Clientes() {
		coleccionClientes = new ArrayList<>();
	}

	public List<Cliente> get() {
		return new ArrayList<>(coleccionClientes);
	}
    //voy a utlizar un metodo de arraylist (.size) para saber la cantidad de una lista

	public int getCantidad() {
		return coleccionClientes.size();
	}
    //voy a utlizar un metodo de arraylist (.Add) para añadir un valor a la lista

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}

		if (coleccionClientes.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		}

		coleccionClientes.add(cliente);
	}
     //voy a utlizar un metodo de Arraylist (.get) para buscar un valor en la lista
	public Cliente buscar(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		int indice = coleccionClientes.indexOf(cliente);
		return indice == -1 ? null : coleccionClientes.get(indice);
	}
	   //voy a utilizar un metodo de arraylist (.remove) para borrar un elemento de la lista

	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		if (!coleccionClientes.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
		coleccionClientes.remove(cliente);
	}
       // voy a utilizar un metodo de Arraylist (.set()) para modificar una lista
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		Cliente clienteBusc = buscar(cliente);
		if (clienteBusc == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		} else {
			if (nombre != null && !nombre.isBlank()) {
				clienteBusc.setNombre(nombre);
			}
			if (telefono != null && !telefono.isBlank()) {
				clienteBusc.setTelefono(telefono);
			}
		}

	}

}