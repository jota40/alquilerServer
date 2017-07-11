package jota.server.dao.impl;

import org.springframework.stereotype.Repository;

import jota.server.dao.ViviendaDao;
import jota.server.entity.Vivienda;

@Repository
public class ViviendaDaoImpl extends GenericDaoImpl<Vivienda, Long> implements ViviendaDao {
}