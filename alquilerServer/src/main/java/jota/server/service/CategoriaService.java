package jota.server.service;

import java.util.List;

import jota.server.dto.CategoriaDto;
import jota.server.dto.Filtro;
import jota.server.exceptions.ServerException;

public interface CategoriaService {
/*	Categoria getOrSaveByNombre( String nombre ) throws ServerException;
	CategoriaDto read( Long id ) throws ServerException;
	List<Categoria> findByIdVivienda( Long idVivienda );
	List<Categoria> findByIdUsuarioLikeNombre( Long idUsuario, String nombre );
	List<Categoria> findByIdUsuario( Long idUsuario );
	void deleteById( Long id ) throws ServerException;*/

	List<CategoriaDto> find( Filtro filtro ) throws ServerException;
}

