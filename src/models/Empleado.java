package models;

public class Empleado {
	private String nombre;
	private String apellido;
	private boolean hombre;
	private int puesto;
	private int sueldo;
	private String fecha;
	private boolean vacas;
	private String comentarios;
	
	public Empleado(String nombre, String apellido, boolean hombre, int puesto, int sueldo, String fecha, boolean vacas,
			String comentarios) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.hombre = hombre;
		this.puesto = puesto;
		this.sueldo = sueldo;
		this.fecha = fecha;
		this.vacas = vacas;
		this.comentarios = comentarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public boolean isHombre() {
		return hombre;
	}

	public void setHombre(boolean hombre) {
		this.hombre = hombre;
	}

	public int getPuesto() {
		return puesto;
	}

	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public boolean isVacas() {
		return vacas;
	}

	public void setVacas(boolean vacas) {
		this.vacas = vacas;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellido=" + apellido + ", hombre=" + hombre + ", puesto=" + puesto
				+ ", sueldo=" + sueldo + ", fecha=" + fecha + ", vacas=" + vacas + ", comentarios=" + comentarios + "]";
	}
	
}
