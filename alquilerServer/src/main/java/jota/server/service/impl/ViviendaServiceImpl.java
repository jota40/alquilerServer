package jota.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import jota.server.dao.UsuarioDao;
import jota.server.dao.ViviendaDao;
import jota.server.dto.Filtro;
import jota.server.dto.FiltroWhere;
import jota.server.dto.ViviendaDtoDown;
import jota.server.dto.ViviendaDtoUp;
import jota.server.entity.Usuario;
import jota.server.entity.Vivienda;
import jota.server.security.SecurityUtils;
import jota.server.service.ViviendaService;

@Service("viviendaService")
@Transactional(readOnly = true)
public class ViviendaServiceImpl implements ViviendaService {

	static final Logger LOG = LoggerFactory.getLogger(ViviendaServiceImpl.class);

    @Autowired
    private ViviendaDao viviendaDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
	public List<ViviendaDtoDown> findAlquilables( Filtro filtro ) throws Exception {
    	Assert.notNull( filtro, "El filtro no puede ser null" );
		List<ViviendaDtoDown> dev = new ArrayList<ViviendaDtoDown>();
		List<Vivienda> aux = viviendaDao.find( filtro, "vivienda" );
		if ( aux != null ) {
			for ( Vivienda vivienda : aux ) {
				dev.add( vivienda.instanceDto() );
			}
		}
		return dev;
	}

	@Override
	public List<ViviendaDtoDown> findMisVivendas( Filtro filtro ) throws Exception {
    	Assert.notNull( filtro, "El filtro no puede ser null" );
		List<ViviendaDtoDown> dev = new ArrayList<ViviendaDtoDown>();

		filtro.add( new FiltroWhere( "and vivienda.usuario.id= :idUsuario", "idUsuario", SecurityUtils.getIdUsuario() ) );
		List<Vivienda> aux = viviendaDao.find( filtro, "vivienda" );
		if ( aux != null ) {
			for ( Vivienda vivienda : aux ) {
				dev.add( vivienda.instanceDto() );
			}
		}
		return dev;
	}

	@Override
	public List<ViviendaDtoDown> findMisVivendasByNombre( Filtro filtro, String nombre ) throws Exception {
    	Assert.notNull( filtro, "El filtro no puede ser null" );
    	Assert.notNull( nombre, "El nombre no puede ser null" );
		List<ViviendaDtoDown> dev = new ArrayList<ViviendaDtoDown>();

		filtro.add( new FiltroWhere( "and vivienda.usuario.id = :idUsuario", "idUsuario", SecurityUtils.getIdUsuario() ) );
		filtro.add( new FiltroWhere( "and vivienda.nombre like :nombre", "nombre", "%" + nombre + "%" ) );
		List<Vivienda> aux = viviendaDao.find( filtro, "vivienda" );
		if ( aux != null ) {
			for ( Vivienda vivienda : aux ) {
				dev.add( vivienda.instanceDto() );
			}
		}
		return dev;
	}
	
	@Override
	public ViviendaDtoDown read( Long id ) throws Exception {
    	Assert.notNull( id, "El id no puede ser null" );
    	return viviendaDao.read( id ).instanceDto();
	}

	@Transactional( rollbackFor = Exception.class )
	@Override
	public void update( Long id, ViviendaDtoUp viviendaDto ) throws Exception {
	   	Assert.notNull( id, "El id no puede ser null" );
	   	Assert.notNull( viviendaDto, "La viviendaDto no puede ser null" );

	   	Vivienda vivienda = viviendaDao.read( id );
		viviendaDao.detach( vivienda );

		vivienda.update( viviendaDto );
		viviendaDao.update( vivienda );
	}

	@Transactional( rollbackFor = Exception.class )
	@Override
	public Long create(ViviendaDtoUp viviendaDto) throws Exception {
	   	Assert.notNull( viviendaDto, "La viviendaDto no puede ser null" );

		Vivienda vivienda = new Vivienda();
		vivienda.update( viviendaDto );

		Usuario usuario = usuarioDao.read( SecurityUtils.getIdUsuario() );
		vivienda.setUsuario( usuario );

		viviendaDao.create( vivienda );
		return  vivienda.getId();
	}
}