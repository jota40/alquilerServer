package jota.server.dto;

import java.util.List;

public class EquipamientoDto extends BaseDto {

	private static final long serialVersionUID = 2052060993122244945L;

	String nombre;
	Long idCategoria;
	String nombreCategoria;
	List<Long> idsViviendas;

	public EquipamientoDto() {}

	public EquipamientoDto( Long id, String nombre, Long idCategoria, String nombreCategoria, List<Long> idsViviendas ) {
		this.id = id;
		this.nombre = null2Blank( nombre );
		this.idCategoria = idCategoria;
		this.nombreCategoria = null2Blank( nombreCategoria );
		this.idsViviendas = idsViviendas;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Long> getIdsViviendas() {
		return idsViviendas;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}
}
