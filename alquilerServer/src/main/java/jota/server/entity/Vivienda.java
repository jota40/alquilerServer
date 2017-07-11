package jota.server.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jota.server.dto.ViviendaDtoDown;
import jota.server.dto.ViviendaDtoUp;
import jota.server.security.SecurityUtils;

@Entity
@Table(name="vivienda")
public class Vivienda extends Base implements IAuditable {

	private String nombre;
	private String situacion;
	private String resumen;
	private Integer capacidad;
	private Usuario usuario;
	@Embedded
	private Auditable auditable;

	public Vivienda() {
	}

	@Column( name="nombre", nullable = false )
	public String getNombre() {
		return nombre;
	}
	public void setNombre( String nombre ) {
		this.nombre = blank2Null( nombre );
	}

	@Column( name="situacion" )
	public String getSituacion() {
		return situacion;
	}
	public void setSituacion( String situacion ) {
		this.situacion = blank2Null( situacion );
	}

	@Column( name="resumen" )
	public String getResumen() {
		return resumen;
	}
	public void setResumen( String resumen ) {
		this.resumen = blank2Null( resumen );
	}
	
	@Column( name="capacidad" )
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad( Integer capacidad ) {
		this.capacidad = null2Zero( capacidad ).intValue();
	}
/*
	@ManyToMany( fetch = FetchType.EAGER, mappedBy="viviendas")
	public Set<Equipamiento> getEquipamiento() {
		return equipamiento;
	}
	public void setEquipamiento(Set<Equipamiento> equipamiento) {
		this.equipamiento = equipamiento;
	}
*/
	@ManyToOne
	@JoinColumn( name="usuario_fk", nullable = false, foreignKey = @ForeignKey(name = "FK_VIVIENDA_2_USUARIO_ID") )
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Auditable getAuditable() {
		return auditable;
	}

	@Override
	public void setAuditable( Auditable auditable ) {
		this.auditable = auditable;
	}

	/**
	 * Genera el dto que se enviara al cliente
	 * @return
	 */
	public ViviendaDtoDown instanceDto() {
		return new ViviendaDtoDown(id, version, nombre, situacion, resumen, capacidad, usuario.getId(), usuario.getId() == SecurityUtils.getIdUsuario() );
	}

	/**
	 * Actuliza con los datos recibidos desde el cliente
	 * @return
	 */
	public void update( ViviendaDtoUp vivienda ) {
		super.update( vivienda );
		setNombre( vivienda.getNombre() );
		setSituacion( vivienda.getSituacion() );
		setResumen( vivienda.getResumen() );
		setCapacidad( vivienda.getCapacidad() );
	}
}