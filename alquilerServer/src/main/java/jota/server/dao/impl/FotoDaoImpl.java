package jota.server.dao.impl;

import org.springframework.stereotype.Repository;

import jota.server.dao.FotoDao;
import jota.server.entity.Foto;

@Repository
public class FotoDaoImpl extends GenericDaoImpl<Foto, Long> implements FotoDao {
}