package cl.dao;

import java.util.List;

import cl.model.Usuario;

public interface UsuarioDao {
	
	String agregarUsuario(Usuario usuario);
	
	Usuario obtenerUsuario(String email);
	
	Usuario recuperarUsuario(String id);
	
	String eliminarUsuario(String email);
	
	String borrarUsuario(String id);
	
	List<Usuario> obtenerUsuarios();
	
	String modificarUsuario(Usuario usuario);
	
	void modificarUsuarioTelefono(String id);
}
