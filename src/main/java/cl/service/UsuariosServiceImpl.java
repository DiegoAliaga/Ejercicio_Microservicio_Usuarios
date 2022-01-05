package cl.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import cl.dao.UsuarioDao;
import cl.mapper.Mapper;
import cl.model.Telefono;
import cl.model.Usuario;
import exceptions.Excepcion;

@Service
@PropertySource(value= {"classpath:values.properties"})
public class UsuariosServiceImpl implements UsuariosService{

	@Autowired
	UsuarioDao dao;
	
	@Value("${app.password}")
	private String pass;
	
	@Value("${app.email}")
	private String mail;
	
	@PostConstruct
	public void init() {
		p1=Pattern.compile(pass);
		p2=Pattern.compile(mail);
	}
	
	Pattern p1;
	Pattern p2;
	
	@Override
	public Usuario agregarUsuario(Usuario usuario) {
		Matcher m1 =p1.matcher(usuario.getPassword());
		Matcher m2 =p2.matcher(usuario.getEmail());
		if(m1.matches()==false) {
			throw new Excepcion("Password no cumple con formato");
		}
		if(m2.matches()==false) {
			throw new Excepcion("Email no cumple con formato");
		}
		if(m1.matches()==true || m2.matches()==true) {
			if(dao.obtenerUsuario(usuario.getEmail())==null) {
				String newId = (UUID.randomUUID().toString());
				usuario.setId(newId);
				usuario.setCreated(new Date());
				usuario.setModified(new Date());
				usuario.setLastLogin(new Date());
				usuario.setActive(true);
				usuario.setToken(newId);
				Usuario u=new Usuario();
				u.setId(newId);
				for(Telefono t:usuario.getTelefonos()) {
					t.setUsuario(u);
				}
			dao.agregarUsuario(usuario);
			return usuario;
			}
			else {
				throw new Excepcion("El Email ya se encuentra en uso");
			}
		}
		return null;
	}

	@Override
	public List<Usuario> recuperarUsuarios() {
		return dao.obtenerUsuarios();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		if(dao.recuperarUsuario(usuario.getId())!=null) {
			Usuario u=dao.recuperarUsuario(usuario.getId());
			dao.modificarUsuarioTelefono(usuario.getId());
			List<Telefono> telefonos;
			/*for(Telefono t:usuario.getTelefonos()) {
				t.setUsuario(usuario.getId());
			}*/
			Usuario uModify=Mapper.getUpdatedUser(u, usuario);
			//dao.modificarUsuario(usuario);
			dao.modificarUsuario(uModify);
			return u;
		}
		return null;
	}

	@Override
	public boolean eliminarUsuario(String id) {
		if(dao.recuperarUsuario(id)!=null) {
			dao.borrarUsuario(id);
			return true;
		}
		return false;
	}

	@Override
	public Usuario buscarUsuario(String id) {
		return dao.recuperarUsuario(id);
	}

}
