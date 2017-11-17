package model;

public class Disco {
	private int id;
	private String titulo;
	private String fecha;
	private String tipoGrabacion;
	private int canciones;
	
	
	
	
	public Disco(int id, String titulo, String fecha, String tipoGrabacion, int canciones) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fecha = fecha;
		this.tipoGrabacion = tipoGrabacion;
		this.canciones = canciones;
	}

	public Disco() {
		this(0, "","", "",0);
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipoGrabacion() {
		return tipoGrabacion;
	}

	public void setTipoGrabacion(String tipoGrabacion) {
		this.tipoGrabacion = tipoGrabacion;
	}

	public int getCanciones() {
		return canciones;
	}

	public void setCanciones(int canciones) {
		this.canciones = canciones;
	}

	@Override
	public String toString() {
		return "Disco [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", tipoGrabacion=" + tipoGrabacion
				+ ", canciones=" + canciones + "]";
	}

	
	
	
}
