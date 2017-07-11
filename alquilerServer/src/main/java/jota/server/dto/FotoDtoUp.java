package jota.server.dto;

public class FotoDtoUp extends BaseDto {

	private static final long serialVersionUID = -8141320762467538258L;

	private String titulo;
	private Integer orden;
	private String md5;
	private String nombreOriginal;
	private Long size;
	private String type;
	private byte[] bytes;

	/**
	 * Constructor para la parte cliente llamado desde los activities crear y editar
	 */
	public FotoDtoUp() {
	}

	// Getters
	public void setTitulo( String titulo ) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public Integer getOrden() {
		return orden;
	}

	public String getMd5() {
		return md5;
	}

	public String getNombreOriginal() {
		return nombreOriginal;
	}

	public Long getSize() {
		return size;
	}

	public String getType() {
		return type;
	}

	public byte[] getBytes() {
		return bytes;
	}

	// Setters
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public void setNombreOriginal(String nombreOriginal) {
		this.nombreOriginal = nombreOriginal;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
}