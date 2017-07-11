package jota.server.entity;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import jota.server.dto.FotoDtoDown;
import jota.server.dto.FotoDtoUp;
import jota.server.enumerations.TagEnum;
import jota.server.security.SecurityUtils;

@Entity
@Table(name="foto")
public class Foto extends Base implements IAuditable{

	private String titulo;
	private String nombreOriginal;
	private String md5;
	private TagEnum tag;
	private Integer orden;
	private Vivienda vivienda;
	private String url;
	private Long size;
	private String type;
	@Embedded
	private Auditable auditable;

	public Foto() {
	}

	@Column( name="titulo", nullable = false )
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo( String titulo ) {
		this.titulo = blank2Null( titulo );
	}

	@Column( name="nombreOriginal", nullable = false )
	public String getNombreOriginal() {
		return nombreOriginal;
	}
	public void setNombreOriginal( String nombreOriginal ) {
		this.nombreOriginal = blank2Null( nombreOriginal );
	}

	@Column( name="md5", nullable = false, unique = true )
	public String getMd5() {
		return md5;
	}
	public void setMd5( String md5 ) {
		this.md5 = blank2Null( md5 );
	}

	@Enumerated(EnumType.ORDINAL)
	@Column( name="tag" )
	public TagEnum getTag() {
		return tag;
	}
	public void setTag( TagEnum tag ) {
		this.tag = tag;
	}

	@Column( name="orden" )
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = null2Zero( orden ).intValue();
	}

	@ManyToOne
	@JoinColumn( name="vivienda_fk", nullable = false, foreignKey = @ForeignKey(name = "FK_FOTO_2_VIVIENDA_ID") )
	public Vivienda getVivienda() {
		return vivienda;
	}
	public void setVivienda( Vivienda vivienda ) {
		this.vivienda = vivienda;
	}

	@Column( name="url", nullable = false, unique = true )
	public String getUrl() {
		return url;
	}
	public void setUrl( String url ) {
		this.url = blank2Null( url );
	}

	@Column( name="size", nullable = false, precision=3 )
	public Long getSize() {
		return size;
	}
	public void setSize( Long size ) {
		this.size = size;
	}

	@Column( name="type", nullable = false )
	public String getType() {
		return type;
	}
	public void setType( String type ) {
		this.type = blank2Null( type );
	}

	@Override
	public Auditable getAuditable() {
		return auditable;
	}

	@Override
	public void setAuditable( Auditable auditable ) {
		this.auditable = auditable;
	}

	/**
	 * Genera el dto que se enviara al cliente
	 * @return
	 */
	public FotoDtoDown instanceDto() {
		return new FotoDtoDown(id, version, titulo, nombreOriginal, tag, orden, vivienda.instanceDto(), size, type, vivienda.getUsuario().getId() == SecurityUtils.getIdUsuario() );
	}

	/**
	 * Actuliza con los datos recibidos desde el cliente
	 * @return
	 */
	public void updateSinFoto( FotoDtoUp foto ) {
		super.update( foto );
		setTitulo( foto.getTitulo() );
		setOrden( foto.getOrden() );
	}

	public void updateConFoto( FotoDtoUp foto ) {
		updateSinFoto( foto );
		setMd5( foto.getMd5() );
		setNombreOriginal( foto.getNombreOriginal() );
		setSize( foto.getSize() );
		setType( foto.getType() );
		setUrl( getServerPath() + File.separator + getFileName() );
	}

	@Transient
	public String getServerPath() {
		return SecurityUtils.getLogin() + File.separator + getClass().getSimpleName();
	}

	@Transient
	public String getFileName() {
		return md5 + nombreOriginal.substring( nombreOriginal.lastIndexOf(".") );
	}
}