package jota.server.dao.impl;

import org.springframework.stereotype.Repository;

import jota.server.dao.DisponibilidadDao;
import jota.server.entity.Disponibilidad;

@Repository
public class DisponibilidadDaoImpl extends GenericDaoImpl<Disponibilidad, Long> implements DisponibilidadDao {
/*
	@Override
	public List<Disponibilidad> findByIdVivienda( Long idVivienda ) {
		List<Disponibilidad> dev = null;
		StringBuilder query = new StringBuilder("FROM Disponibilidad d" +
				" WHERE d.vivienda.id = :idVivienda");
		try {
			Query result = entityManager.createQuery( query.toString() );
			result.setParameter( "idVivienda", idVivienda );
			dev = result.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dev;
	}*/
}