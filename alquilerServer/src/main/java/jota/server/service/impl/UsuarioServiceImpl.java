package jota.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import jota.server.dao.UsuarioDao;
import jota.server.dto.Filtro;
import jota.server.dto.FiltroWhere;
import jota.server.entity.Usuario;
import jota.server.exceptions.DaoException;
import jota.server.exceptions.ServerException;
import jota.server.exceptions.ServiceException;
import jota.server.service.UsuarioService;

@Service("usuarioService")
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {

	static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public Usuario getByLogin( String login ) throws ServerException {
		Assert.notNull( login, "El login no puede ser null" );
		Usuario dev = null;
		List<Usuario> coleccion = null;
		try {
			Filtro filtro = new Filtro();
			filtro.add( new FiltroWhere( "and usuario.login = :login", "login", login ) );
			coleccion = usuarioDao.find( filtro, "usuario" );
		} catch ( DaoException daoException ) {
			LOG.error( daoException.getUsrMessage() );
			throw daoException;
		} catch ( Exception exception ) {
			LOG.error( exception.getLocalizedMessage() );
			throw new ServiceException( exception );
		}
		if ( coleccion != null ) {
			switch ( coleccion.size() ) {
				case 1: dev = coleccion.iterator().next();
				break;
				case 0: throw new ServiceException("No existe ningún usuario con login = " + login );
				default: throw new ServiceException("Se ha encontrado más de 1 usuari con login = " + login );
			}
		}
		return dev;
	}
}