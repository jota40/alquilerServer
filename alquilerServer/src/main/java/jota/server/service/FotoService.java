package jota.server.service;

import java.io.FileInputStream;
import java.util.List;

import jota.server.dto.Filtro;
import jota.server.dto.FotoDtoDown;
import jota.server.dto.FotoDtoUp;

public interface FotoService {
	List<FotoDtoDown> findFotosDeMiVivienda( Long idVivienda, Filtro filtro ) throws Exception;
	List<FotoDtoDown> findMisFotos( Filtro filtro ) throws Exception;
	FotoDtoDown read( Long id ) throws Exception;
	void update( Long id, FotoDtoUp foto, Integer idTag, Long idVivienda ) throws Exception;
	Long create( FotoDtoUp foto, Integer idTag, Long idVivienda ) throws Exception;
	void delete( Long id ) throws Exception;
	FileInputStream getFoto( Long id ) throws Exception;
}