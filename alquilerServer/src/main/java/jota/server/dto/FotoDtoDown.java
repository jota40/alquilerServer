package jota.server.dto;

import jota.server.enumerations.TagEnum;

public class FotoDtoDown extends BaseDto {

	private static final long serialVersionUID = -8141320762467538258L;

	private String titulo;
	private String nombreOriginal;
	private TagEnum tag;
	private Integer orden;
	private ViviendaDtoDown vivienda;
	private Long size;
	private String type;
	private boolean mia;

	public FotoDtoDown() {
	}

	/**
	 * Constructor para la parte servidor llamado desde los entities
	 * @param nombreOriginal 
	 * @param url 
	 * @param type 
	 * @param size 
	 * @param capacidad 
	 * @param descripcion2 
	 */
	public FotoDtoDown( Long id, Long version, String titulo, String nombreOriginal, TagEnum tag, Integer orden, ViviendaDtoDown vivienda, Long size, String type, boolean mia ) {
		this.id = id;
		this.version = version;
		this.titulo = titulo;
		this.nombreOriginal = nombreOriginal;
		this.tag = tag;
		this.orden = orden;
		this.vivienda = vivienda;
		this.size = size;
		this.type = type;
		this.mia = mia;
	}

	// Getters
	public String getTitulo() {
		return titulo;
	}

	public String getNombreOriginal() {
		return nombreOriginal;
	}

	public TagEnum getTag() {
		return tag;
	}

	public Integer getOrden() {
		return orden;
	}

	public ViviendaDtoDown getVivienda() {
		return vivienda;
	}

	public Long getSize() {
		return size;
	}

	public String getType() {
		return type;
	}

	// Auxiliares
	public String getTagNombre() {
		return tag == null ? "" : tag.name();
	}

	public boolean isMia() {
		return mia;
	}
	
	public Long getIdVivienda() {
		return vivienda.getId();
	}

	public String getViviendaNombre() {
		return vivienda.getNombre();
	}
}