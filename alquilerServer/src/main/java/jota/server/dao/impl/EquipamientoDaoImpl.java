package jota.server.dao.impl;

import org.springframework.stereotype.Repository;

import jota.server.dao.EquipamientoDao;
import jota.server.entity.Equipamiento;

@Repository
public class EquipamientoDaoImpl extends GenericDaoImpl<Equipamiento, Long> implements EquipamientoDao {
/*
	@Override
	public Equipamiento getByNombreCode( String nombreCode ) {
		StringBuilder query = new StringBuilder("FROM Equipamiento e" +
				" WHERE e.nombreCode = :nombreCode");
		Query result = entityManager.createQuery( query.toString() );
		result.setParameter( "nombreCode", nombreCode );
		return (Equipamiento) result.getSingleResult();
	}

	@Override
	public List<Equipamiento> findByIdViviendaSinCategoria( Long idVivienda ) {
		StringBuilder query = new StringBuilder("SELECT DISTINCT e.*" +
				" FROM equipamiento e" +
				" JOIN vivienda_equipamiento ve on e.id = ve.equipamiento_fk" +
				" WHERE ve.vivienda_fk = :idVivienda and e.categoria_fk is null");
		Query result = entityManager.createNativeQuery( query.toString() );
//		result.addEntity( Categoria.class);
		result.setParameter( "idVivienda", idVivienda );
		return result.getResultList();
	}

	@Override
	public List<Equipamiento> findByIdViviendaIdCategoria( Integer idCategoria, Integer idVivienda ) {
		StringBuilder query = new StringBuilder("SELECT DISTINCT e.*" +
				" FROM equipamiento e" +
				" JOIN vivienda_equipamiento ve on e.id = ve.equipamiento_fk" +
				" WHERE ve.vivienda_fk = :idVivienda and e.categoria_fk := idCategoria");
		Query result = entityManager.createNativeQuery( query.toString() );
//		result.addEntity( Equipamiento.class);
		result.setParameter( "idVivienda", idVivienda );
		result.setParameter( "idCategoria", idCategoria );
		return result.getResultList();
	}

	@Override
	public List<Equipamiento> findByIdUsuarioLikeNombre( Long idUsuario, String nombre ) {
		StringBuilder query = new StringBuilder("FROM Equipamiento e" +
				" WHERE e.nombre like :nombre and e.usuario.id = :idUsuario");
		Query result = entityManager.createQuery( query.toString() );
		result.setParameter( "idUsuario", idUsuario );
		result.setParameter( "nombre", "%"+nombre+"%" );
		return result.getResultList();
	}

	@Override
	public List<Equipamiento> findByIdUsuarioIdCategoria( Long idUsuario, Long idCategoria ) {
		StringBuilder query = new StringBuilder("FROM Equipamiento e" +
				" WHERE e.categoria.id = :idCategoria and e.usuario.id = :idUsuario");
		Query result = entityManager.createQuery( query.toString() );
		result.setParameter( "idUsuario", idUsuario );
		result.setParameter( "idCategoria", idCategoria );
		return result.getResultList();
	}

	@Override
	public List<Equipamiento> findSinCategoriaByIdUsuario( Long idUsuario ) throws DaoException {
		StringBuilder query = new StringBuilder("SELECT e.* FROM equipamiento e" +
				" WHERE e.categoria_fk is null and e.usuario_fk = :idUsuario");
		List<Equipamiento> dev = null;
		try {
			Query result = entityManager.createNativeQuery( query.toString() );
//			result.addEntity( Equipamiento.class );
			result.setParameter( "idUsuario", idUsuario );
			dev  = result.getResultList();
		} catch (Exception e) {
			throw new DaoException( e );
		}
		return dev;
	}

	@Override
	public Equipamiento findByIdUsuarioNombreCode( Long idUsuario, String nombreCode ) {
		StringBuilder query = new StringBuilder("FROM Equipamiento e" +
				" WHERE e.nombreCode = :nombreCode and e.usuario.id = :idUsuario");
		Query result = entityManager.createQuery( query.toString() );
		result.setParameter( "idUsuario", idUsuario );
		result.setParameter( "nombreCode", nombreCode );
		return (Equipamiento) result.getSingleResult();
	}
*/}