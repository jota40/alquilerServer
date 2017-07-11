package jota.server;

import java.util.ArrayList;
import java.util.List;

import jota.server.entity.Categoria;
import jota.server.entity.Equipamiento;
import jota.server.service.CategoriaService;
import jota.server.service.EquipamientoService;
import jota.server.service.ViviendaService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:/spring/config/BeanLocations.xml" )
@TransactionConfiguration( defaultRollback = true )
public class AppTest {

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	EquipamientoService caracteristicaService;

	@Autowired
	ViviendaService viviendaService;

	@Test
	@Transactional
	public void insertCategoriaSinCaracteristicas() {
		Categoria categoria = new Categoria( "Cat1", null );
///		Long idCategoria = categoriaService.save( categoria, null );

	//	System.out.println(categoriaService.getById( idCategoria ));
	}
/*
	@Test
	@Transactional
	public void insertarCategoriaConCaracteristicas() {
		Categoria categoria = new Categoria( "Cat1", null  );

		List<Equipamiento> caracteristicas = new ArrayList<Equipamiento>();
		caracteristicas.add( new Equipamiento("Car1", null ) );
		caracteristicas.add( new Equipamiento("Car2", null ) );

		Long idCategoria = categoriaService.save( categoria, caracteristicas );

		System.out.println(categoriaService.getById( idCategoria ));
	}

	@Test
	@Transactional
	public void modificarCaracteristicasDeUnaCategoria() {
		Categoria categoria = new Categoria( "Cat1", null  );

		List<Equipamiento> caracteristicas = new ArrayList<Equipamiento>();
		caracteristicas.add( new Equipamiento("Car1", null ) );
		caracteristicas.add( new Equipamiento("Car2", null ) );

		Long idCategoria = categoriaService.save( categoria, caracteristicas );
		System.out.println(categoriaService.getById( idCategoria ));

		caracteristicas.clear();
		caracteristicas.add( new Equipamiento("Car3", null ) );

		idCategoria = categoriaService.save( categoria, caracteristicas );
		System.out.println(categoriaService.getById( idCategoria ));
	}


	@Test
	@Transactional
	public void insertarCaracteristicaConCategoria() {
		Categoria categoria = new Categoria( "Cat1", null );
		Equipamiento caracteristica = new Equipamiento( "Car1", null );

		Long idCaracteristica = caracteristicaService.save(caracteristica, categoria);
		System.out.println(caracteristicaService.getById( idCaracteristica ));
	}

	@Test
	@Transactional
	public void insertCategoriaYCaracteristica() {
		Long idCategoria = categoriaService.save( new Categoria( "Cat1", null ), null );
		System.out.println(categoriaService.getById( idCategoria ));

		Long idCaracteristica = caracteristicaService.save( new Equipamiento( "Car1", null ), idCategoria );
		System.out.println(caracteristicaService.getById( idCaracteristica ));
	}

	@Test
	@Transactional
	public void insertViviendaConCaracteristicas() {
		Categoria categoria = new Categoria( "Cat1", null  );

		List<Equipamiento> caracteristicas = new ArrayList<Equipamiento>();
		caracteristicas.add( new Equipamiento("Car1", null ) );
		caracteristicas.add( new Equipamiento("Car2", null ) );

		Long idCategoria = categoriaService.save( categoria, caracteristicas );

		categoria = categoriaService.getById( idCategoria );

		Vivienda vivienda = new Vivienda( "Viv1", null  );

		Long idVivienda = viviendaService.save( vivienda, categoria.getCaracteristicas() );

		System.out.println(viviendaService.getById( idVivienda ));		
	}*/
}
