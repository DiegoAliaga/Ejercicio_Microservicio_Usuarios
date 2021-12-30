package cl.mapper;

import java.util.Date;

import cl.model.Usuario;

public class Mapper {

	public static Usuario getUpdatedUser(Usuario usuario, Usuario usuarioP) {
		usuario.setNombre(usuarioP.getNombre());
		usuario.setEmail(usuarioP.getEmail());
		usuario.setPassword(usuarioP.getPassword());
		//usuario.setTelefonos(usuarioP.getTelefonos());
		usuario.setActive(usuarioP.isActive());
		usuario.setModified(new Date());
		usuario.setCreated(usuarioP.getCreated());
		return usuario;
	}
}
