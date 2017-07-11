package jota.server.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import jota.server.dao.FotoDao;
import jota.server.dao.ViviendaDao;
import jota.server.dto.Filtro;
import jota.server.dto.FiltroWhere;
import jota.server.dto.FotoDtoDown;
import jota.server.dto.FotoDtoUp;
import jota.server.entity.Foto;
import jota.server.entity.Vivienda;
import jota.server.enumerations.TagEnum;
import jota.server.exceptions.ServiceException;
import jota.server.security.SecurityUtils;
import jota.server.service.FotoService;

@Service("fotoService")
@Transactional(readOnly = true)
public class FotoServiceImpl implements FotoService {

	static final Logger LOG = LoggerFactory.getLogger(FotoServiceImpl.class);

	@Autowired
	ServletContext servletContext;

	@Autowired
    private FotoDao fotoDao;

    @Autowired
    private ViviendaDao viviendaDao;

    @Override
	public List<FotoDtoDown> findFotosDeMiVivienda( Long idVivienda, Filtro filtro ) throws Exception {
    	Assert.notNull( idVivienda, "El idVivienda no puede ser null" );
    	Assert.notNull( filtro, "El filtro no puede ser null" );
		List<FotoDtoDown> dev = new ArrayList<FotoDtoDown>();

		filtro.add( new FiltroWhere( "and foto.vivienda.id= :idVivienda", "idVivienda", idVivienda ) );
		List<Foto> aux = fotoDao.find( filtro, "foto" );
		if ( aux != null ) {
			for ( Foto foto : aux ) {
				dev.add( foto.instanceDto() );
			}
		}

		return dev;
	}

	@Override
	public List<FotoDtoDown> findMisFotos(Filtro filtro) throws Exception {
    	Assert.notNull( filtro, "El filtro no puede ser null" );
		List<FotoDtoDown> dev = new ArrayList<FotoDtoDown>();

		filtro.add( new FiltroWhere( "and foto.vivienda.usuario.id= :idUsuario", "idUsuario", SecurityUtils.getIdUsuario() ) );
		List<Foto> aux = fotoDao.find( filtro, "foto" );
		if ( aux != null ) {
			for ( Foto foto : aux ) {
				dev.add( foto.instanceDto() );
			}
		}

		return dev;
	}

	@Override
	public FotoDtoDown read( Long id ) throws Exception {
    	Assert.notNull( id, "El id no puede ser null" );
		return fotoDao.read( id ).instanceDto();
	}

	@Transactional( rollbackFor = Exception.class )
	@Override
	public void update( Long id, FotoDtoUp fotoDto, Integer idTag, Long idVivienda ) throws Exception {
	   	Assert.notNull( id, "El id no puede ser null" );
	   	Assert.notNull( fotoDto, "La fotoDto no puede ser null" );
	   	Assert.notNull( idTag, "El idTag no puede ser null" );
	   	Assert.notNull( idVivienda, "El idVivienda no puede ser null" );

		Foto foto = fotoDao.read( id );
		foto.updateSinFoto( fotoDto );

		foto.setTag( TagEnum.values()[idTag] );

		Vivienda vivienda = viviendaDao.read( idVivienda );
		foto.setVivienda( vivienda );

		fotoDao.update( foto );
	}

	@Transactional( rollbackFor = Exception.class )
	@Override
	public Long create( FotoDtoUp fotoDto, Integer idTag, Long idVivienda ) throws Exception {
	   	Assert.notNull( fotoDto, "La fotoDto no puede ser null" );
	   	Assert.notNull( idTag, "El idTag no puede ser null" );
	   	Assert.notNull( idVivienda, "El idVivienda no puede ser null" );
	   	Assert.notNull( fotoDto.getBytes(), "El fichero no puede ser null" );

		Foto foto = new Foto();
		foto.updateConFoto( fotoDto );

		foto.setTag( TagEnum.values()[idTag] );

		Vivienda vivienda = viviendaDao.read( idVivienda );
		foto.setVivienda( vivienda );

		fotoDao.create( foto );
		fotoDao.flush();

		// Save file
		String diskPath = getDiskPath();

        // creates the save directory if it does not exists
        File fileSaveDir = new File( diskPath + File.separator + foto.getServerPath() );
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        BufferedOutputStream stream = new BufferedOutputStream( new FileOutputStream( new File( diskPath + foto.getServerPath() + File.separator + foto.getFileName() ) ) );
        stream.write( fotoDto.getBytes() );
        stream.close();

		return foto.getId();
	}

	@Transactional( rollbackFor = Exception.class )
	@Override
	public void delete( Long id ) throws Exception {
	   	Assert.notNull( id, "El idno puede ser null" );

		Foto foto = fotoDao.read( id );
		String diskPath = getDiskPath();
		fotoDao.delete( foto );
		fotoDao.flush();
        File fileRemove = new File( diskPath + foto.getServerPath() + File.separator + foto.getFileName() );
        if ( !fileRemove.delete() ) {
			throw new ServiceException( "No se ha podido borrar la foto " + foto.getFileName() );
        }
	}
	
	private String getDiskPath() {
		String dev = System.getenv("OPENSHIFT_DATA_DIR");
		// Comprobamos NO si estamos openshift
		if ( dev == null || dev.length() == 0) { 
			dev = servletContext.getRealPath("/") + File.separator;
		}
//		LOG.info( "OPENSHIFT_DATA_DIR = " + dev + "alquier" + File.separator );
//		LOG.info( "SERVER = " + servletContext.getRealPath("/") + File.separator );

		return dev + "alquier" + File.separator;
	}

	@Override
	public FileInputStream getFoto( Long id ) throws Exception {
		Foto foto = fotoDao.read( id );
		String diskPath = getDiskPath();
        File file = new File( diskPath + foto.getServerPath() + File.separator + foto.getFileName() );
        return  new FileInputStream(file);
	}
}