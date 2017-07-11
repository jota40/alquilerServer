package jota.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jota.server.dto.CategoriaDto;

@Entity
@Table(name="categoria")
public class Categoria extends Base {

	private String nombre;
	private String nombreCode;
	private String descripcion;
	private Usuario usuario;

    public Categoria() {
	}

	public Categoria( String nombre, String descripcion ) {
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

	@ManyToOne
	@JoinColumn( name="usuario_fk", nullable = false )
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		String dev =	"[ id = " + id + ", " +
						"nombre = " + nombre + ", " +
						"descripcion = " + descripcion + " ]";
		return dev;
	}
	public CategoriaDto instanceDto() {
		// TODO Auto-generated method stub
		return null;
	}
}