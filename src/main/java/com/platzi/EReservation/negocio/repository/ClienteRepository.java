package com.platzi.EReservation.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.EReservation.modelo.Cliente;

/**
 * interfaz para las operaciones de bases de datos de los clientes
 * @author yojan
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	public List<Cliente> findByApellido(String apellido);
	public Cliente findByIdDocument(String idDocument);
}
