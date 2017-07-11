package jota.server.dto;

public class ViviendaDtoDown extends BaseDto {

	private static final long serialVersionUID = -8141320762467538258L;

	private String nombre;
	private String situacion;
	private String resumen;
	private Integer capacidad;
	private Long idUsuario;
	private boolean mia;

	public ViviendaDtoDown() {
	}

	/**
	 * Constructor para la parte servidor llamado desde los entities
	 * @param capacidad 
	 * @param descripcion2 
	 */
	public ViviendaDtoDown( Long id, Long version, String nombre, String situacion, String resumen, Integer capacidad, Long idUsuario, boolean mia ) {
		this.id = id;
		this.version = version;
		this.nombre = null2Blank( nombre );
		this.situacion = null2Blank( situacion );
		this.resumen = null2Blank( resumen );
		this.capacidad = null2Zero( capacidad ).intValue();
		this.idUsuario = idUsuario;
		this.mia = mia;
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

	public Long getIdUsuario() {
		return idUsuario;
	}
	
	//Auxiliares
	public boolean isMia() {
		return mia;
	}
}