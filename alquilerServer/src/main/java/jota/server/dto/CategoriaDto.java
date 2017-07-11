package jota.server.dto;

public class CategoriaDto extends BaseDto {
	String nombre;
	String descripcion;

	public CategoriaDto() {}

	public CategoriaDto(Long id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = null2Blank( nombre );
		this.descripcion = null2Blank( descripcion );
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
}