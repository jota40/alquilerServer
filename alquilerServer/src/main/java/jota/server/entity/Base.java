package jota.server.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import jota.server.dto.BaseDto;
import jota.server.exceptions.DaoException;
import jota.server.security.SecurityUtils;

@MappedSuperclass
public abstract class Base {

	protected Long id;
	protected Long version;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId( Long id ) {
		this.id = id;
	}
	
	@Version
	@Column(name="version", columnDefinition="bigint DEFAULT 0")
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
        	 !( obj instanceof Base ) )
        {
        	return false;
        }
        
        Base objBase = (Base) obj;
        if ( id != null && objBase.id != null && id.equals( objBase.id ) ) {
        	return true;
        }
        return false;
	}

	protected String blank2Null( String string ) {
		return string == null || string.trim().length() == 0 ? null : string;
	}
	
	protected Number null2Zero( Number numero ) {
		return  numero == null ? 0 : numero;
	}

	@PrePersist
	void preCreate() {
		if ( this instanceof IAuditable ) {
			((IAuditable)this).setAuditable( new Auditable() );
			((IAuditable)this).getAuditable().setCreado( new Timestamp( new Date().getTime() ) );
			((IAuditable)this).getAuditable().setCreadoPor( SecurityUtils.getIdUsuario() );
	
		}
	}

	@PreUpdate
	void preUpdate() throws DaoException {
		if ( this instanceof IAuditable ) {
			if ( ((IAuditable)this).getAuditable().getCreadoPor() != SecurityUtils.getIdUsuario() ) {
				throw new DaoException("Security access violation");
			}
			((IAuditable)this).getAuditable().setModificado( new Timestamp( new Date().getTime() ) );
			((IAuditable)this).getAuditable().setModificadoPor( SecurityUtils.getIdUsuario() );
		}
	}

	@PreRemove
	void preRemove() throws DaoException {
		if ( SecurityUtils.getIdUsuario() == null ) {
			throw new DaoException("Security access violation");
		}
		if ( this instanceof IAuditable ) {
			if ( ((IAuditable)this).getAuditable().getCreadoPor() != SecurityUtils.getIdUsuario() ) {
				throw new DaoException("Security access violation");
			}
		}
	}
	protected void update( BaseDto base ) {
		version = base.getVersion();
	}
}