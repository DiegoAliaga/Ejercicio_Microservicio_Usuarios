package cl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.model.Usuario;
import cl.service.UsuariosService;
import exceptions.Excepcion;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UsuarioController {

	@Autowired
	UsuariosService service;
	
	@GetMapping(value="usuarios", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> recuperarUsuarios() {
		return service.recuperarUsuarios();
	}
	
	@GetMapping(value="usuarios/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Usuario recuperarUsuarios(@PathVariable("id") String id){
		return service.buscarUsuario(id);
	}
	
	@PostMapping(path="usuarios", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
		service.agregarUsuario(usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@DeleteMapping(value="usuario/{id}")
	public ResponseEntity borrarUsuario(@PathVariable("id") String id){
		service.eliminarUsuario(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value="usuario", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity actualizarUsuario(@RequestBody Usuario usuario) {
		Usuario u =service.actualizarUsuario(usuario);
		return ResponseEntity.ok(u);
	}
	
	@ExceptionHandler(Excepcion.class)
	public ResponseEntity<String> manejarError(Excepcion e){
		return new ResponseEntity<>(e.getMensaje(), HttpStatus.BAD_REQUEST);
	}
}
