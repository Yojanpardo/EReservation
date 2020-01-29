/**
 * 
 */
package com.platzi.EReservation.vista.resources.vo;

import lombok.Data;

/**
 * clase que representa la tabla de cliente
 * Usamos la anotacion Data para evitarnos todo lo de crear getters y setters 
 * @author yojan
 *
 */
@Data
public class ClienteVO {
	private String idCliente;
	private String nombre;
	private String apellido;
	private String idDocument;
	private String direccion;
	private String email;
	private String telefono;
}
