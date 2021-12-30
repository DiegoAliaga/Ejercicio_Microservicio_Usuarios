package cl.service;

import java.util.List;

import cl.model.Usuario;

public interface UsuariosService {

	Usuario agregarUsuario(Usuario usuario);
	List<Usuario> recuperarUsuarios();
	boolean actualizarUsuario(Usuario usuario);
	boolean eliminarUsuario(String id);
	Usuario buscarUsuario(String id);
}
