package ar.edu.unlam.tallerweb1.modelo.formularios;

public class FormNuevoPartido {
	private String nombreCancha;
	private String latitud;
	private String longitud;
	
	public String getNombreCancha() {
		return nombreCancha;
	}
	public void setNombreCancha(String nombreCancha) {
		this.nombreCancha = nombreCancha;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	private String descripcion;
}
