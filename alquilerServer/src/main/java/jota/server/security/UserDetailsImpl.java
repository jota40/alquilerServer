package jota.server.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jota.server.entity.Usuario;
import jota.server.entity.Vivienda;

public class UserDetailsImpl implements UserDetails{
	private static final long serialVersionUID = -6509897037222767090L;
	
	private Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	private Usuario usuario;
	
	public UserDetailsImpl( Usuario usuario, Set<GrantedAuthority> authorities){
		this.usuario = usuario;
		this.authorities = authorities;
	}
	@Override
	public Set<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return usuario.getPass();
	}

	@Override
	public String getUsername() {
		return usuario.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
