package jota.server.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jota.server.entity.Usuario;
import jota.server.exceptions.ServerException;
import jota.server.service.UsuarioService;

@Service("myUserDetailService")
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		Usuario usuario = null ;
		try {
			usuario = usuarioService.getByLogin( username );
		} catch (ServerException e) {
			throw new UsernameNotFoundException("Error en el servicio getByLogin( " + username + " )", e);
		}
		if ( usuario == null ) {
			throw new UsernameNotFoundException("Wrong username or password");
		}
		authorities.add( new GrantedAuthorityImpl( usuario.getRol() ) );
		return new UserDetailsImpl( usuario, authorities );
	}
}