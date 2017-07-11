package jota.server.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="disponibilidad")
public class Disponibilidad extends Base {

	private Date desde;
	private Date hasta;
	private Integer minNumDias;
	private Vivienda vivienda;
	private Usuario usuario;
	private Estado estado;

	public Disponibilidad() {
	}

	@Column( name="desde", nullable = false )
	public Date getDesde() {
		return desde;
	}
	public void setDesde(Date desde) {
		this.desde = desde;
	}

	@Column( name="hasta", nullable = false )
	public Date getHasta() {
		return hasta;
	}
	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	@Column( name="min_num_dias" )
	public Integer getMinNumDias() {
		return minNumDias;
	}
	public void setMinNumDias(Integer minNumDias) {
		this.minNumDias = minNumDias;
	}

	@ManyToOne
	@JoinColumn( name="vivienda_fk", nullable=false )
	public Vivienda getVivienda() {
		return vivienda;
	}
	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	@ManyToOne
	@JoinColumn( name="usuario_fk", nullable = false )
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne
	@JoinColumn( name="estado_fk", nullable = false )
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}