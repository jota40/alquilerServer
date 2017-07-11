package jota.server.service;

import java.util.List;

import jota.server.dto.Filtro;
import jota.server.dto.ViviendaDtoDown;
import jota.server.dto.ViviendaDtoUp;

public interface ViviendaService {
	List<ViviendaDtoDown> findAlquilables( Filtro filtro ) throws Exception;
	List<ViviendaDtoDown> findMisVivendas( Filtro filtro ) throws Exception;
	List<ViviendaDtoDown> findMisVivendasByNombre( Filtro filtro, String query ) throws Exception;
	ViviendaDtoDown read( Long id ) throws Exception;
	void update( Long id, ViviendaDtoUp vivienda ) throws Exception;
	Long create( ViviendaDtoUp vivienda ) throws Exception;
}