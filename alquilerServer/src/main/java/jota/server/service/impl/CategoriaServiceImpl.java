package jota.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import jota.server.dao.CategoriaDao;
import jota.server.dto.CategoriaDto;
import jota.server.dto.Filtro;
import jota.server.entity.Categoria;
import jota.server.exceptions.DaoException;
import jota.server.exceptions.ServerException;
import jota.server.exceptions.ServiceException;
import jota.server.service.CategoriaService;

@Service("categoriaService")
@Transactional(readOnly = true)
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;
/*
	@Autowired
	private UsuarioDao usuarioDao;

    @Autowired
    private EquipamientoService equipamientoService;

    @Override
    @Transactional(readOnly = false)
	public Categoria getOrSaveByNombre( String nombre ) throws ServerException {
		String nombreCode = nombre.trim().toLowerCase().replaceAll(" ", "-");

		Categoria categoria = categoriaDao.findByIdUsuarioNombreCode( SecurityUtils.getIdUsuario(), nombreCode );
		
		if ( categoria == null ) { 
			Usuario usuario = usuarioDao.read( SecurityUtils.getIdUsuario() );
	
			categoria = new Categoria( nombre, null );
			categoria.setUsuario( usuario );
			categoriaDao.create( categoria );
		}

    	return categoria;
    }

	@Override
    @Transactional(readOnly = false)
	public CategoriaDto read( Long pk ) throws ServerException {
		Assert.notNull( pk, "La pk id no puede ser null" );
		CategoriaDto dev = null;
		try {
			dev = categoriaDao.read( pk ).instanceDto();
    	} catch ( DaoException daoException ) {
			throw daoException;
    	} catch ( Exception exception ) {
			throw new ServiceException( exception );
		}
		return dev;
	}
	
	@Override
	@Transactional(readOnly = false)
	public List<Categoria> findByIdVivienda( Long idVivienda ) {
		return categoriaDao.findByIdVivienda( idVivienda );
	}

	@Override
	@Transactional(readOnly = false)
	public List<Categoria> findByIdUsuarioLikeNombre( Long idUsuario, String nombre ) {
		return categoriaDao.findByIdUsuarioLikeNombre( idUsuario, nombre );
	}

	@Override
	@Transactional(readOnly = false)
	public List<Categoria> findByIdUsuario( Long idUsuario ) {
		return categoriaDao.findByIdUsuario( idUsuario );
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById( Long pk ) throws ServerException {
		//FIXME comprobar si la categoria a borrar pertenec a usuario logueado
		try {
			categoriaDao.delete( pk );	
    	} catch ( DaoException daoException ) {
			throw daoException;
    	} catch ( Exception exception ) {
			throw new ServiceException( exception );
		}
	}*/
	@Override
	@Transactional(readOnly = false)
	public List<CategoriaDto> find( Filtro filtro ) throws ServerException {
		Assert.notNull( filtro, "El filtro no puede ser null" );
		List<CategoriaDto> dev = new ArrayList<CategoriaDto>();
		try {
			//FIXME comprobar el usuario
			List<Categoria> aux = categoriaDao.find( filtro, "categoria" );
			if ( aux != null ) {
				for ( Categoria equipamiento : aux ) {
					dev.add( equipamiento.instanceDto() );
				}
			}
    	} catch ( DaoException daoException ) {
			throw daoException;
    	} catch ( Exception exception ) {
			throw new ServiceException( exception );
		}
		return dev;
	}
}