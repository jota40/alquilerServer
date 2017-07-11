package jota.server.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import jota.server.entity.Usuario;
import jota.server.enumerations.RolEnum;
import jota.server.util.UtilsJava;

public class SecurityUtils {

	private static UserDetailsImpl getUseDetails() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication auth = context == null ? null : context.getAuthentication();
		Object principal = (auth == null ? null : auth.getPrincipal());
		if (principal != null && principal instanceof UserDetailsImpl) {
			return (UserDetailsImpl) principal;
		}
		return null;
	}

	public static Long getIdUsuario() {
		return getUseDetails() == null || getUseDetails().getUsuario() == null ? null : getUseDetails().getUsuario().getId();
	}

	public static String getNombreUsuario() {
		String dev = null;
		if (getUseDetails() != null && getUseDetails().getUsuario() != null) {
			Usuario usuario = getUseDetails().getUsuario();
			dev = UtilsJava.Cadenas.concat(usuario.getNombre(), usuario.getApellido1(), usuario.getApellido2());
		}
		return dev;
	}

	public static String getLogin() {
		return getUseDetails() == null || getUseDetails().getUsuario() == null ? null : getUseDetails().getUsuario().getLogin();
	}

	public static RolEnum getRol() {
		return getUseDetails() == null || getUseDetails().getUsuario() == null ? RolEnum.INVITADO : getUseDetails().getUsuario().getRol();
	}
}