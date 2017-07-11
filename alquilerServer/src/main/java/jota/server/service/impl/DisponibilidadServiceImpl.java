package jota.server.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jota.server.service.DisponibilidadService;

@Service("disponibilidadService")
@Transactional(readOnly = true)
public class DisponibilidadServiceImpl implements DisponibilidadService {
/*
    @Autowired
    private DisponibilidadDao disponibilidadDao;

    @Autowired
    private ViviendaDao viviendaDao;

    @Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private EstadoDao estadoDao;

	@Override
    @Transactional(readOnly = false)
	public Disponibilidad saveOrUpdate( Disponibilidad disponibilidad, Integer idEstado ) throws ServerException {
		Usuario usuario = usuarioDao.read( SecurityUtils.getIdUsuario() );
		Estado estado = estadoDao.read( idEstado );
		Vivienda vivienda = viviendaDao.read( SecurityUtils.getIdVivienda() );

		disponibilidad.setUsuario( usuario );
		disponibilidad.setEstado( estado );
		disponibilidad.setVivienda( vivienda );
		
    	disponibilidadDao.create( disponibilidad );
    	return disponibilidad;
    }

	@Override
    @Transactional(readOnly = false)
	public Disponibilidad getById( Long id ) throws ServerException {
    	return disponibilidadDao.read( id );
	}
	
	@Override
	@Transactional(readOnly = false)
	public List<Disponibilidad> findByIdVivienda( Long idVivienda ) {
		return disponibilidadDao.findByIdVivienda( idVivienda );
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById( Long id ) throws ServerException {
		Disponibilidad disponibilidad = disponibilidadDao.read( id );
		if ( !SecurityUtils.getIdUsuario().equals( disponibilidad.getUsuario().getId() ) ) {
			throw new ServiceException("no puedes borrar la disponibilidad de otro usuario");
		}
		if ( !SecurityUtils.getIdVivienda().equals( disponibilidad.getVivienda().getId() ) ) {
			throw new ServiceException("no puedes borrar la disponibilidad de una vivienda noseleccionada");
		}
		disponibilidadDao.delete( disponibilidad );
	}*/
}