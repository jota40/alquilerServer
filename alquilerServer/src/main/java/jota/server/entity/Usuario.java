package jota.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import jota.server.enumerations.RolEnum;

@Entity
@Table(name="usuario")
public class Usuario extends Base {

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String login;
	private String pass;
	private String email;
	private RolEnum rol;
	private String dni;

	public Usuario() {
	}

	@Column( name="nombre", nullable = false )
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column( name="apellido1", nullable = false, unique = true )
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	@Column( name="apellido2"  )
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Column( name="login", nullable = false, unique = true )
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	@Column( name="pass", nullable = false, unique = true )
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Column( name="email", nullable = false, unique = true )
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Enumerated(EnumType.STRING)
	@Column( name="rol", nullable = false )
	public RolEnum getRol() {
		return rol;
	}
	public void setRol(RolEnum rol) {
		this.rol = rol;
	}

	@Column( name="dni", unique = true )
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

}