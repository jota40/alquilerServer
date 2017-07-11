package jota.server.service;

import jota.server.entity.Usuario;
import jota.server.exceptions.ServerException;

public interface UsuarioService {
//	Long save( Usuario usuario ) throws ServerException;
	Usuario getByLogin( String username ) throws ServerException;
}

