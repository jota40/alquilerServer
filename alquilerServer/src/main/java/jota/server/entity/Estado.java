package jota.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Estado extends Base {

	private String nombre;
	private String nombreCode;
	private String descripcion;

    public Estado() {
	}

	public Estado( String nombre, String descripcion ) {
		this.nombre = nombre;
		this.nombreCode = nombre.trim().toLowerCase().replaceAll(" ", "-");
		this.descripcion = descripcion;
	}

	@Column( name="nombre", nullable = false, unique = true )
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column( name="nombreCode", nullable = false, unique = true )
	public String getNombreCode() {
		return nombreCode;
	}
	public void setNombreCode(String nombreCode) {
		this.nombreCode = nombreCode;
	}

	@Column(name="descripcion")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		String dev =	"[ id = " + id + ", " +
						"nombre = " + nombre + ", " +
						"descripcion = " + descripcion + " ]";
		return dev;
	}
}