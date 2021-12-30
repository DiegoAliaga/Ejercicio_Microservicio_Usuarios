package cl.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="usuario")
public class Usuario {

	@Id
	//@GeneratedValue
	private String id;
	private String nombre;
	private String email;
	private String password;
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="usuario")
	//@JoinColumn(name = "id", referencedColumnName = "id")
	private List<Telefono> telefonos;
	private Date created;
	private Date modified;
	private Date lastLogin;
	private String token;
	private boolean active;
}
