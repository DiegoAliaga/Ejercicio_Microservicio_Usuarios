package cl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.model.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{

	@Autowired
	UsuarioJpaSpring usuarioJpa;
	
	@Override
	public String agregarUsuario(Usuario usuario) {
		usuarioJpa.save(usuario);
		return "Registrado";
	}

	@Override
	public Usuario obtenerUsuario(String email) {
		return usuarioJpa.findByEmail(email);
	}
	
	@Override
	public Usuario recuperarUsuario(String id) {
		return usuarioJpa.findById(id);
	}

	@Override
	public String eliminarUsuario(String email) {
		usuarioJpa.eliminarUsuarioEmail(email);
		return "Eliminado";
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		return usuarioJpa.findAll();
	}

	@Override
	public String modificarUsuario(Usuario usuario) {
		usuarioJpa.save(usuario);
		return "Actualizado";
	}

	@Override
	public String borrarUsuario(String id) {
		usuarioJpa.borrarUsuario(id);
		return "Eliminado";
	}
	
	@Override
	public void modificarUsuarioTelefono(String id) {
		usuarioJpa.borrarTelefono(id);
	}


}
