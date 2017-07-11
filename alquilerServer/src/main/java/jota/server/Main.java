package jota.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jota.server.service.CategoriaService;
import jota.server.service.EquipamientoService;
import jota.server.service.ViviendaService;

@Component
public class Main {
	public static void main(String[] args)  throws Exception {
	}

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	EquipamientoService equipamientoService;

	@Autowired
	ViviendaService viviendaService;

	protected void mainInternal(String[] args) throws Exception {
	}
}