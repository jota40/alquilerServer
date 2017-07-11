package jota.server.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Filtro implements Serializable {

	private static final long serialVersionUID = 434906658212536332L;

	private List<FiltroWhere> where;

	private int start;
	private int size;

	public Filtro() {
		this( 0, 0, new ArrayList<FiltroWhere>() );
	}

	public Filtro( int start, int size ) {
		this( start, size, new ArrayList<FiltroWhere>() );
	}

	public Filtro( List<FiltroWhere> where ) {
		this( 0, 0, where );
	}

	public Filtro( int start, int size, List<FiltroWhere> where ) {
		this.start = start;
		this.size = size;
		this.where = where;
	}

	public List<FiltroWhere> getWhere() {
		return where;
	}

	public void setWhere(List<FiltroWhere> where) {
		this.where = where;
	}

	public void add(FiltroWhere filtroWhere) {
		where.add( filtroWhere );
	}

	public void addAll(List<FiltroWhere> where) {
		where.addAll( where );
	}

	public int getStart() {
		return start;
	}

	public int getSize() {
		return size;
	}
}