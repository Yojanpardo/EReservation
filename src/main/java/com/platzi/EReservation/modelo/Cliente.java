/**
 * 
 */
package com.platzi.EReservation.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * clase que representa la tabla de cliente
 * Usamos la anotacion Data para evitarnos todo lo de crear getters y setters 
 * @author yojan
 *
 */
@Data
@Entity
@Table(name = "cliente")
@NamedQuery(name = "Cliente.findByIdDocument", query = "Select c from Cliente c where c.idDocument = ?1")
public class Cliente {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idCliente;
	private String nombre;
	private String apellido;
	private String idDocument;
	private String direccion;
	private String email;
	private String telefono;
	
	@OneToMany(mappedBy = "cliente")
	private Set<Reserva> reservas;
	/**
	 * Constructor vacio
	 */
	public Cliente() {
		super();
	}
	
	
}
