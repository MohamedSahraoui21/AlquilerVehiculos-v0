	package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;
	
	import java.time.LocalDate;
	import java.time.Period;
	import java.time.format.DateTimeFormatter;
	import java.util.Objects;
	
	import javax.naming.OperationNotSupportedException;
	
	public class Alquiler {
		static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		private static final int PRECIO_DIA = 20;
		   //atributos//
		
	
		private LocalDate fechaAlquiler;
		private LocalDate fechaDevolucion;
		private Cliente cliente;
		private Turismo turismo;
	    //constructores//
	
		public Alquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {
			setCliente(cliente);
			setTurismo(turismo);
			setFechaAlquiler(fechaAlquiler);
	
		}
	
		public Alquiler(Alquiler alquiler) {
			if (alquiler == null) {
				throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
			}
			this.cliente = new Cliente(alquiler.getCliente());
			this.turismo = new Turismo(alquiler.getTurismo());
			this.fechaAlquiler = alquiler.getFechaAlquiler();
			this.fechaDevolucion = alquiler.getFechaDevolucion();
	
		}
	    //getters y setters
	
		public LocalDate getFechaAlquiler() {
			return fechaAlquiler;
		}
	
		public LocalDate getFechaDevolucion() {
			return fechaDevolucion;
		}
	
		public Cliente getCliente() {
			return cliente;
		}
	
		public Turismo getTurismo() {
			return turismo;
		}
	
		private void setFechaAlquiler(LocalDate fechaAlquiler) {
			LocalDate hoy = LocalDate.now();
			if (fechaAlquiler == null) {
				throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
			}
			if (fechaAlquiler.isAfter(hoy)) {
				throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
			}
			this.fechaAlquiler = fechaAlquiler;
		}
	
		private void setFechaDevolucion(LocalDate fechaDevolucion) {
			LocalDate hoy = LocalDate.now();
			if (fechaDevolucion == null) {
				throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
			}
			if (fechaDevolucion.isAfter(hoy)) {
				throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
			}
			if (fechaDevolucion.equals(fechaAlquiler) || fechaDevolucion.isBefore(fechaAlquiler)) {
				throw new IllegalArgumentException(
						"ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
			}
			this.fechaDevolucion = fechaDevolucion;
		}
	
		private void setCliente(Cliente cliente) {
			if (cliente == null) {
				throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
			}
			this.cliente = cliente;
		}
	
		private void setTurismo(Turismo turismo) {
			if (turismo == null) {
				throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
			}
			this.turismo = turismo;
		}
	
		public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {
			if (this.fechaDevolucion != null) {
				throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
			}
			setFechaDevolucion(fechaDevolucion);
	
		}
	
		public int getPrecio() {
			int dias = 0;
			int factorCilindrada = turismo.getCilindrada() / 10;
			if (fechaDevolucion != null) {
				dias = Period.between(fechaAlquiler, fechaDevolucion).getDays();
			}
			return (PRECIO_DIA + factorCilindrada) * dias;
	
		}
	    //hashcode y equals
		@Override
		public int hashCode() {
			return Objects.hash(cliente, fechaAlquiler, turismo);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof Alquiler))
				return false;
			Alquiler other = (Alquiler) obj;
			return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
					&& Objects.equals(turismo, other.turismo);
		}
		    //tostring//
		@Override
		public String toString() {
			String tostring;
			if (fechaDevolucion == null) {
				tostring= String.format("%s <---> %s, %s - %s (%d€)", cliente, turismo,
						fechaAlquiler.format(Alquiler.FORMATO_FECHA), "Aún no devuelto", 0);
			}
				else {
				tostring= String.format("%s <---> %s, %s - %s (%d€)", cliente, turismo,
						fechaAlquiler.format(Alquiler.FORMATO_FECHA), fechaDevolucion.format(Alquiler.FORMATO_FECHA),
						getPrecio());
			}
			return tostring;
			
	
		}
}