package jota.server.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Auditable {

	private Long creadoPor;
	private Timestamp creado;
	private Long modificadoPor;
	private Timestamp modificado;

	public Auditable() {}

	@Column(name = "creado_por", nullable = false, columnDefinition="bigint DEFAULT 0")
	public Long getCreadoPor() {
		return creadoPor;
	}
	public void setCreadoPor(Long creadoPor) {
		this.creadoPor = creadoPor;
	}

	@Column(name = "creado", nullable = false, columnDefinition="TIMESTAMP DEFAULT NOW()")
	public Date getCreado() {
		return creado;
	}
	public void setCreado(Timestamp creado) {
		this.creado = creado;		
	}

	@Column(name = "modificado_por")
	public Long getModificadoPor() {
		return modificadoPor;
	}
	public void setModificadoPor(Long modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	@Column(name = "modificado", columnDefinition="TIMESTAMP")
	public Date getModificado() {
		return modificado;
	}
	public void setModificado(Timestamp modificado) {
		this.modificado = modificado;
	}
}