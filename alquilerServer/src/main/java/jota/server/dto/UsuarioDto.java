package jota.server.dto;

public class UsuarioDto extends BaseDto {
	String nombre;

	public UsuarioDto() {}

	public UsuarioDto(Long id, String nombre) {
		this.id = id;
		this.nombre = null2Blank( nombre );
	}

}
