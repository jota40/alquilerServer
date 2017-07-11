package jota.server.security;

import org.springframework.security.core.GrantedAuthority;

import jota.server.enumerations.RolEnum;

public class GrantedAuthorityImpl implements GrantedAuthority{

	private static final long serialVersionUID = 1029928088340565343L;

	private RolEnum rol;
	
	public GrantedAuthorityImpl( RolEnum rol ){
		this.rol = rol;
	}
	
	@Override
	public String getAuthority() {
		return rol.name();
	}
}
