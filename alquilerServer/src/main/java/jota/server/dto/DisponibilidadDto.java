package jota.server.dto;

import java.util.Date;

public class DisponibilidadDto extends BaseDto {

	Date desde;
	Date hasta;
	Integer minNumDias;
	Long idEstado;

	public DisponibilidadDto() {}

	public DisponibilidadDto(Long id, Date desde, Date hasta, Integer minNumDias, Long idEstado) {
		this.id = id;
		this.desde = desde;
		this.hasta = hasta;
		this.minNumDias = minNumDias;
		this.idEstado = idEstado;
	}

	public Long getId() {
		return id;
	}

	public Date getDesde() {
		return desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public Integer getMinNumDias() {
		return minNumDias;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public void setMinNumDias(Integer minNumDias) {
		this.minNumDias = minNumDias;
	}

	public void setIdEstado( Long idEstado ) {
		this.idEstado = idEstado;
	}
}
