package jota.server.enumerations;
public enum EstadoEnum {
    LIBRE( 1L, "Libre" ),
    PENDIENTE( 2L, "Pendiente" ),
    OCUPADO( 3L, "Ocupado" );

    private Long id;
    private String descripcion;

    private EstadoEnum() {
        this.id = null;
        this.descripcion = null;
    }

    private EstadoEnum( Long id, String descripcion ) {
        this.id = id;
        this.descripcion = descripcion;
    }
 
    public Long getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static EstadoEnum getEnum( Object id ) {
    	try {
    		return getEnum( Integer.parseInt( id.toString() ) );
    	} catch (Exception e) {
			return null;
		}
    }
 
    private static EstadoEnum getEnum( int id ) {
    	switch ( id ) {
			case 1: return LIBRE;
			case 2: return PENDIENTE;
			case 3: return OCUPADO;
    	}
    	return null;
    }
}