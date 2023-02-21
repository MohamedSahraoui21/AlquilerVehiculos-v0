package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {
	SALIR("SALIR"),
	INSERTAR_CLIENTE("Insertar cliente"),
	INSERTAR_TURISMO("insertar turismo"),
	INSERTAR_ALQUILER("insertar alquiler"),
	BUSCAR_CLIENTE("buscar cliente"),
	BUSCAR_TURISMO("buscar turismo"),
	BUSCAR_ALQUILER("buscar alquiler"),
	MODIFICAR_CLIENTE("modificar cliente"),
	DEVOLVER_ALQUILER("devolver alquiler"),
	BORRAR_CLIENTE("borrar cliente"),
	BORRAR_TURISMO("borrar turismo"),
	BORRAR_ALQUILER("borra alquiler"),
	LISTAR_CLIENTES("listar clientes"),
	LISTAR_TURISMOS("listar turismos"),
	LISTAR_ALQUILERES("listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("listar alquileres de cliente"),
	LISTAR_ALQUILERES_TURISMO("listar alquileres de turismo");

	private String texto;
	
	private Opcion(String texto) {
		this.texto=texto;
	}
	private boolean esOrdinalValido(int ordinal) {
		if(ordinal>=values().length ||ordinal<0) {
			return false;
		}
		return true;
	}
	public Opcion get(int ordinal) {
		if(!esOrdinalValido(ordinal)) {
			throw new IllegalArgumentException("el ordinal no es correcto");
			
		}
		return values()[ordinal];
	}
	
	@Override
	public String toString() {
		return String.format("%d . %s",ordinal(),texto);
	}
}
