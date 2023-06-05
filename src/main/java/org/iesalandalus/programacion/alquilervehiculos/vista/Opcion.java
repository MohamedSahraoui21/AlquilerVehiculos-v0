	package org.iesalandalus.programacion.alquilervehiculos.vista;
	
	public enum Opcion {
		SALIR("salir."),
		INSERTAR_CLIENTE("insertar cliente"),
		INSERTAR_TURISMO("insertar turismo"),
		INSERTAR_ALQUILER("insertar alquiler"),
		BUSCAR_CLIENTE("buscar cliente"),
		BUSCAR_TURISMO("buscar turismo"),
		BUSCAR_ALQUILER("buscar alquiler"),
		MODIFICAR_CLIENTE("modificar cliente"),
		DEVOLVER_ALQUILER("devolver alquiler"),
		BORRAR_CLIENTE("borrar cliente"),
		BORRAR_TURISMO("borrar turismo"),
		BORRAR_ALQUILER("borrar alquiler"),
		LISTAR_CLIENTES("listar clientes"),
		LISTAR_TURISMOS("listar turismos"),
		LISTAR_ALQUILERES("listar alquileres"),
		LISTAR_ALQUILERES_CLIENTE("listar alquileres de cliente"),
		LISTAR_ALQUILERES_TURISMO("listar alquileres de turismo");
		
	
		private String texto;

		private Opcion(String texto) {
			this.texto = texto;
		}

		private static boolean esOrdinalValido(int num) {
			return num >= 0 && num <= values().length - 1;
		}

		public static Opcion get(int num) {
			if (!esOrdinalValido(num)) {
				throw new ArrayIndexOutOfBoundsException("el ordinal no es correcto");

			}
			return values()[num];
		}

		@Override
		public String toString() {
			return String.format("%d - %s", ordinal(), texto);
		}
	}
