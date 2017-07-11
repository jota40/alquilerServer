package jota.server.dao;

import java.io.Serializable;
import java.util.List;

import jota.server.dto.Filtro;
import jota.server.exceptions.DaoException;

public interface GenericDao<T, PK extends Serializable> {

    void create(T e) throws DaoException;
    T read( PK pk ) throws DaoException;
    void update(T e) throws DaoException;
    void delete( PK pk ) throws DaoException;
    void delete( T e ) throws DaoException;
    List<T> find( Filtro filtro, String alias ) throws DaoException;
	void flush() throws DaoException;
	void detach(T e) throws DaoException;
}
