package cl.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="telefono")
public class Telefono {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;
	private int numero;
	private int codCiudad;
	private int codPais;

}