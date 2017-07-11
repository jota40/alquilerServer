package jota.server.service;

import java.util.List;

import jota.server.dto.EquipamientoDto;
import jota.server.dto.Filtro;
import jota.server.exceptions.ServerException;

public interface EquipamientoService {
/*	Equipamiento getOrSaveByNombre( String nombre, Long idCategoria ) throws ServerException;
	List<Equipamiento> getAll() throws ServerException;
	Equipamiento getById( Long id ) throws ServerException;
	List<Equipamiento> findByIdUsuarioIdCategoria( Long idUsuario, Long idCategoria );
	List<Equipamiento> findSinCategoriaByIdUsuario( Long idUsuario ) throws ServerException;
	void deleteById( Long id ) throws ServerException;
	void unlinkCategoriaByIdCategoria(Long idCategoria) throws ServerException;
	void unlinkCategoriaById(Long id) throws ServerException;
	Equipamiento update( Equipamiento equipamiento, Long idCategoria ) throws ServerException;
*/
	List<EquipamientoDto> find( Filtro filtro ) throws ServerException;
}
