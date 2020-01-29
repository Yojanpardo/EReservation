/**
 * 
 */
package com.platzi.EReservation.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.EReservation.modelo.Cliente;
import com.platzi.EReservation.negocio.repository.ClienteRepository;

/**
 * Clase para determinar los servicios del cliente
 * @author yojan
 *
 */
@Service
@Transactional(readOnly = true)
public class ClienteService {
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Transactional
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	@Transactional
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	@Transactional
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}
	
	public Cliente findByIdDocument(String idDocument) {
		return this.clienteRepository.findByIdDocument(idDocument);
	}
	
	public List<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}
}
