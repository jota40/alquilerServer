package jota.server.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.Assert;

import jota.server.dao.GenericDao;
import jota.server.dto.Filtro;
import jota.server.dto.FiltroWhere;
import jota.server.exceptions.DaoException;

public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T,PK> {

	protected Class<T> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	public GenericDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public void create( T e ) throws DaoException {
		try {
		    entityManager.persist( e );
		}catch (Exception ex) {
			throw new DaoException( ex );
		}
	}

	@Override
	public T read( PK pk ) throws DaoException {
		try {
			T dev = (T) entityManager.find( entityClass, pk );
	        return dev;
		}catch (Exception ex) {
			throw new DaoException( ex );
		}
	}

	@Override
	public void update( T e ) throws DaoException {
		try {
	        entityManager.merge( e );
		}catch (Exception ex) {
			throw new DaoException( ex );
		}
	}

	@Override
	public void delete( T e ) throws DaoException {
		try {
			entityManager.remove( entityManager.merge( e ) );
		}catch (Exception ex) {
			throw new DaoException( ex );
		}
	}

	@Override
	public void delete( PK pk ) throws DaoException {
		try {
			T e = entityManager.getReference( entityClass, pk );
			entityManager.remove( e );
		}catch (Exception ex) {
			throw new DaoException( ex );
		}
	}

	@Override
	public List<T> find( Filtro filtro, String alias ) throws DaoException {
		Assert.notNull( filtro, "El filtro no puede ser null" );
		List<T> dev = new ArrayList<T>();
		try {
			String query = "SELECT " + alias + " FROM " + entityClass.getName() + " " + alias;
			String where = " WHERE 1=1 ";

			for ( FiltroWhere filtroWhere : filtro.getWhere() ) {
				where += filtroWhere.getSql();
			}

			Query result = entityManager.createQuery( query + where );
			for ( FiltroWhere filtroWhere : filtro.getWhere() ) {
				result.setParameter( filtroWhere.getParameter(), filtroWhere.getValor() );
			}
			result.setFirstResult( filtro.getStart() );
			if ( filtro.getSize() > 0 ) {
				result.setMaxResults( filtro.getSize() );
			}

			dev = result.getResultList();
		}catch (Exception ex) {
			throw new DaoException( ex );
		}
		return dev;
	}

	@Override
	public void flush() throws DaoException {
		try {
			entityManager.flush();
		}catch (Exception ex) {
			throw new DaoException( ex );
		}
	}

	@Override
	public void detach( T e ) throws DaoException {
		try {
			entityManager.detach( e );
		}catch (Exception ex) {
			throw new DaoException( ex );
		}
	}
}