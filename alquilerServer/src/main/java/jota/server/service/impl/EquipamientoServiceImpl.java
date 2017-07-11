package jota.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import jota.server.dao.EquipamientoDao;
import jota.server.dto.EquipamientoDto;
import jota.server.dto.Filtro;
import jota.server.entity.Equipamiento;
import jota.server.exceptions.DaoException;
import jota.server.exceptions.ServerException;
import jota.server.exceptions.ServiceException;
import jota.server.service.EquipamientoService;

@Service("equipamientoService")
@Transactional(readOnly = true)
public class EquipamientoServiceImpl implements EquipamientoService {
	@Autowired
	private EquipamientoDao equipamientoDao;
	/*

	@Autowired
	private CategoriaDao categoriaDao;

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private ViviendaDao viviendaDao;

	@Override
	@Transactional(readOnly = false)
	public Equipamiento getOrSaveByNombre( String nombre, Long idCategoria ) throws ServerException {
		String nombreCode = nombre.trim().toLowerCase().replaceAll(" ", "-");

		Equipamiento equipamiento = equipamientoDao.findByIdUsuarioNombreCode( SecurityUtils.getIdUsuario(), nombreCode );

		if ( equipamiento == null ) { 
			Usuario usuario = usuarioDao.read( SecurityUtils.getIdUsuario() );
			Categoria categoria = categoriaDao.read( idCategoria );
	
			equipamiento = new Equipamiento( nombre, null );
			equipamiento.setUsuario( usuario );
			equipamiento.setCategoria( categoria );
	
			equipamientoDao.create( equipamiento );
		}
		return equipamiento;
	}

	@Override
	@Transactional(readOnly = false)
	public List<Equipamiento> getAll() throws ServerException {
		return equipamientoDao.find( new Filtro( 0, 0 ) );
	}

	@Override
	@Transactional(readOnly = false)
	public Equipamiento getById( Long id ) throws ServerException {
		return equipamientoDao.read( id );
	}


	@Override
	@Transactional(readOnly = false)
	public List<Equipamiento> findByIdUsuarioIdCategoria( Long idUsuario, Long idCategoria ) {
		return equipamientoDao.findByIdUsuarioIdCategoria( idUsuario, idCategoria );
	}

	@Override
	@Transactional(readOnly = false)
	public List<Equipamiento> findSinCategoriaByIdUsuario(Long idUsuario) throws ServerException {
		return equipamientoDao.findSinCategoriaByIdUsuario( idUsuario );
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById( Long id ) throws ServerException {
		Equipamiento equipamiento = equipamientoDao.read( id );
		if ( !SecurityUtils.getIdUsuario().equals( equipamiento.getUsuario().getId() ) ) {
			throw new ServiceException("no puedes borrar el equipamiento de otro usuario");
		}
		equipamientoDao.delete( equipamiento );	
	}

	@Override
	@Transactional(readOnly = false)
	public void unlinkCategoriaByIdCategoria( Long idCategoria ) throws ServerException {
		List<Equipamiento> equipamientos = equipamientoDao.findByIdUsuarioIdCategoria( SecurityUtils.getIdUsuario(), idCategoria);
		if ( equipamientos != null ) {
			for (Equipamiento equipamiento : equipamientos) {
				if ( !SecurityUtils.getIdUsuario().equals( equipamiento.getUsuario().getId() ) ) {
					throw new ServiceException("no puedes borrar la categoria de un equipamiento de otro usuario");
				}
				equipamiento.setCategoria( null );
				equipamientoDao.update( equipamiento );
			}
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void unlinkCategoriaById( Long id ) throws ServerException {
		Equipamiento equipamiento = equipamientoDao.read( id );
		if ( !SecurityUtils.getIdUsuario().equals( equipamiento.getUsuario().getId() ) ) {
			throw new ServiceException("no puedes borrar la categoria de un equipamiento de otro usuario");
		}
		equipamiento.setCategoria( null );
		equipamientoDao.update( equipamiento );
	}

	@Override
	@Transactional(readOnly = false)
	public Equipamiento update( Equipamiento equipamiento, Long idCategoria ) throws ServerException {
		Categoria categoria = categoriaDao.read( idCategoria );
		equipamiento.setCategoria( categoria );
		equipamientoDao.update( equipamiento );
    	return equipamiento;
	}*/
	@Override
	@Transactional(readOnly = false)
	public List<EquipamientoDto> find( Filtro filtro ) throws ServerException {
		Assert.notNull( filtro, "El filtro no puede ser null" );
		List<EquipamientoDto> dev = new ArrayList<EquipamientoDto>();
		try {
			//FIXME comprobar el usuario
			List<Equipamiento> aux = equipamientoDao.find( filtro, "equipamiento" );
			if ( aux != null ) {
				for ( Equipamiento equipamiento : aux ) {
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