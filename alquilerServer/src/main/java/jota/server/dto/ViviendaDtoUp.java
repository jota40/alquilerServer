package jota.server.dto;

public class ViviendaDtoUp extends BaseDto {

	private static final long serialVersionUID = -8141320762467538258L;

	private String nombre;
	private String situacion;
	private String resumen;
	private Integer capacidad;

	/**
	 * Constructor para la parte cliente llamado desde los activities crear y editar
	 */
	public ViviendaDtoUp() {
	}

	// Getters
	public String getNombre() {
		return nombre;
	}

	public String getSituacion() {
		return situacion;
	}

	public String getResumen() {
		return resumen;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	// Setters
	public void setNombre( String nombre ) {
		this.nombre = nombre;
	}
	
	public void setSituacion( String situacion ) {
		this.situacion = situacion;
	}

	public void setResumen( String resumen ) {
		this.resumen = resumen;
	}

	public void setCapacidad( Integer capacidad ) {
		this.capacidad = capacidad;
	}
}