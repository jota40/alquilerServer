package jota.server.dao.impl;

import org.springframework.stereotype.Repository;

import jota.server.dao.UsuarioDao;
import jota.server.entity.Usuario;

@Repository
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Long> implements UsuarioDao {
}