package cl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import cl.model.Usuario;

public interface UsuarioJpaSpring extends JpaRepository<Usuario,Integer>{
	Usuario findByEmail(String email);
	Usuario findById(String id);
	@Transactional
	@Modifying
	@Query("Delete from Usuario u Where u.email=?1")
	void eliminarUsuarioEmail(String email);
	
	@Transactional
	@Modifying
	@Query("Update Usuario set active = false Where id=?1 ")
	void borrarUsuario(String id);
}
