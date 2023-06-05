	package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;
	
	import java.util.ArrayList;
	import java.util.List;
	import javax.naming.OperationNotSupportedException;
	import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
	
	public class Turismos {
		
		
		private List <Turismo> coleccionTurismos;
	    //constructor por defecto que crea el arraylist

		public Turismos() {
			coleccionTurismos = new ArrayList<>();
		}
		
		public List<Turismo> get(){
			return new ArrayList<>(coleccionTurismos);
		}
	    //voy a utlizar un metodo de arraylist (.size) para saber la cantidad de una lista

		public int getCantidad() {
			return coleccionTurismos.size();
		}
	    //voy a utlizar un metodo de arraylist (.Add) para añadir un valor a la lista

		public void insertar(Turismo turismo) throws OperationNotSupportedException {
			if (turismo == null) {
				throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
			}
			if (coleccionTurismos.contains(turismo)) {
				throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
			}
			coleccionTurismos.add(turismo);
		}
	
	     //voy a utlizar un metodo de Arraylist (.get) para buscar un valor en la lista

		public Turismo buscar(Turismo turismo) {
			Turismo turismoEncontrado;
			if (turismo == null) {
				throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
			}
			int indice = coleccionTurismos.indexOf(turismo);
			if (coleccionTurismos.contains(turismo)) {
				turismoEncontrado = coleccionTurismos.get(indice);
			} else {
				turismoEncontrado = null;
			}
			return turismoEncontrado;
		}
		   //voy a utilizar un metodo de arraylist (.remove) para borrar un elemento de la lista

		public void borrar(Turismo turismo) throws OperationNotSupportedException {
	
			if (turismo == null) {
				throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
			}
			if (!coleccionTurismos.contains(turismo)) {
				throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
			}
			coleccionTurismos.remove(turismo);
		}
	
	}