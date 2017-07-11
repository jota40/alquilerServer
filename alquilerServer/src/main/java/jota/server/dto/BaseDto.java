package jota.server.dto;

import java.io.Serializable;

public class BaseDto implements Serializable {

	private static final long serialVersionUID = 2833328423367951112L;

	protected Long id;
	protected Long version;

	public BaseDto() {}

	public Long getId() {
		return id;
	}

	public Long getVersion() {
		return version;
	}
	public void setVersion( Long version ) {
		this.version = version;
	}

	@Override
	public boolean equals( final Object obj ) {
        if ( this == obj ) {
        	return true;
        }

        if ( obj == null || 
        	 !( obj instanceof BaseDto ) )
        {
        	return false;
        }
        
        BaseDto objBase = (BaseDto) obj;
        if ( id != null && objBase.id != null && id.equals( objBase.id ) ) {
        	return true;
        }
        return false;
	}
	
	protected String null2Blank( String string ) {
		return string == null ? "" : string;
	}
	
	protected Number null2Zero( Number numero ) {
		return  numero == null ? 0 : numero;
	}
}