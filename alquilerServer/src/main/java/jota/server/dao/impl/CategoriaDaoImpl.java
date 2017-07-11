package jota.server.dao.impl;

import org.springframework.stereotype.Repository;

import jota.server.dao.CategoriaDao;
import jota.server.entity.Categoria;

@Repository
public class CategoriaDaoImpl extends GenericDaoImpl<Categoria, Long> implements CategoriaDao {
/*
	@Override
	public Categoria getByNombreCode( String nombreCode ) {
		StringBuilder query = new StringBuilder("FROM Categoria c" +
				" WHERE c.nombreCode = :nombreCode");
		Query result = entityManager.createQuery( query.toString() );
		result.setParameter( "nombreCode", nombreCode );
		return (Categoria) result.getSingleResult();
	}

	
	@Override
	public List<Categoria> findLikeNombre( String nombre ){
		StringBuilder query = new StringBuilder("FROM Categoria c" +
				" WHERE c.nombre like :nombre");
		Query result = entityManager.createQuery( query.toString() );
		result.setParameter( "nombre", "%"+nombre+"%" );
		return result.getResultList();
	}

	@Override
	public List<Categoria> findByIdVivienda( Long idVivienda ) {
		StringBuilder query = new StringBuilder("SELECT DISTINCT c.* FROM categoria c" +
				" JOIN equipamiento e on c.id = e.categoria_fk" +
				" JOIN vivienda_equipamiento ve on e.id = ve.equipamiento_fk" +
				" WHERE ve.vivienda_fk = :idVivienda");
		Query result = entityManager.createNativeQuery( query.toString() );
//		result.setEntity( Categoria.class);
		result.setParameter( "idVivienda", idVivienda );
		return result.getResultList();
	}

	@Override
	public List<Categoria> findByIdUsuarioLikeNombre( Long idUsuario, String nombre ) {
		StringBuilder query = new StringBuilder("FROM Categoria c" +
				" WHERE c.nombre like :nombre and c.usuario.id = :idUsuario");
		Query result = entityManager.createQuery( query.toString() );
		result.setParameter( "idUsuario", idUsuario );
		result.setParameter( "nombre", "%"+nombre+"%" );
		return result.getResultList();
	}

	@Override
	public List<Categoria> findByIdUsuario(Long idUsuario) {
		StringBuilder query = new StringBuilder("FROM Categoria c" +
				" WHERE c.usuario.id = :idUsuario");
		Query result = entityManager.createQuery( query.toString() );
		result.setParameter( "idUsuario", idUsuario );
		return result.getResultList();
	}

	@Override
	public Categoria findByIdUsuarioNombreCode( Long idUsuario, String nombreCode ) {
		StringBuilder query = new StringBuilder("FROM Categoria c" +
				" WHERE c.nombreCode = :nombreCode and c.usuario.id = :idUsuario");
		Query result = entityManager.createQuery( query.toString() );
		result.setParameter( "idUsuario", idUsuario );
		result.setParameter( "nombreCode", nombreCode );
		return (Categoria) result.getSingleResult();
	}*/
}