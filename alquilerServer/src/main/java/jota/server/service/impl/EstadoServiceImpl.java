package jota.server.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jota.server.service.EstadoService;

@Service("estadoService")
@Transactional(readOnly = true)
public class EstadoServiceImpl implements EstadoService {
/*
    @Autowired
    private EstadoDao estadoDao;

    @Override
    @Transactional(readOnly = false)
	public Integer save( Estado estado ) throws ServerException {
    	estadoDao.create(  estado );
    	return estado.getId();
    }

	@Override
    @Transactional(readOnly = false)
	public Estado getById( Integer id ) throws ServerException {
    	return estadoDao.read( id );
	}

	@Override
	@Transactional(readOnly = false)
	public List<Estado> getAll() throws ServerException {
    	return estadoDao.find( new Filtro( 0, 0 ) );
	}*/
}