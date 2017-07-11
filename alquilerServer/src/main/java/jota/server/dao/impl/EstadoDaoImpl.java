package jota.server.dao.impl;

import org.springframework.stereotype.Repository;

import jota.server.dao.EstadoDao;
import jota.server.entity.Estado;

@Repository
public class EstadoDaoImpl extends GenericDaoImpl<Estado, Integer> implements EstadoDao {

}