package jota.server.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jota.server.dto.EquipamientoDto;

@Entity
@Table(name="equipamiento")
public class Equipamiento extends Base {

	private String nombre;
	private String nombreCode;
	private String descripcion;
	private Categoria categoria;
	private Set<Vivienda> viviendas;
	private Usuario usuario;

	public Equipamiento() {
	}

	public Equipamiento( String nombre, String descripcion ) {
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
	@JoinColumn( name="categoria_fk" )
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToMany( fetch = FetchType.EAGER, cascade = {CascadeType.ALL} )
	@JoinTable( name="vivienda_equipamiento",
				joinColumns={@JoinColumn(name="equipamiento_fk")},
				inverseJoinColumns={@JoinColumn(name="vivienda_fk")}
	)
	public Set<Vivienda> getViviendas() {
		return viviendas;
	}
	public void setViviendas(Set<Vivienda> viviendas) {
		this.viviendas = viviendas;
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
		Throwable t = new Throwable();
		String caller = t.getStackTrace()[1].getClassName();

		String dev = "[id = " + id + ", " +
				"nombre = " + nombre + ", " +
				"descripcion = " + descripcion +
				toStringCategoria( caller ) +
				toStringVivienda( caller ) + "]";
		return dev;
	}


	private String toStringCategoria( String caller ) {
		String dev = "";
/*		if ( categoria != null && !caller.endsWith( Categoria.class.getSimpleName() ) ) {
			dev += ", categoria = " + categoria.toString();
		}
*/		return dev;
	}

	private String toStringVivienda( String caller ) {
		String dev = "";
/*		if ( !caller.endsWith( Vivienda.class.getSimpleName() ) ) {
			dev += ", viviendas = [ "; 
			if ( viviendas == null ) {
				dev = "null ]";
			} else {
				String aux = "";
				for (Vivienda vivienda : viviendas) {
					aux += ( aux == "" ? "" : ", ") + vivienda.toString();
				}
				dev += aux + " ]"; 
			}

		}
*/		return dev;
	}


	public EquipamientoDto instanceDto() {
		// TODO Auto-generated method stub
		return null;
	}

}