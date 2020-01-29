/**
 * 
 */
package com.platzi.EReservation.vista.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.EReservation.modelo.Cliente;
import com.platzi.EReservation.negocio.services.ClienteService;
import com.platzi.EReservation.vista.resources.vo.ClienteVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * representa el servicio web de los clientes
 * 
 * @author yojan
 *
 */
@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {

	private final ClienteService clienteService;

	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	@ApiOperation(value = "Crear un cliente", notes = "Método para crear un cliente")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Solicitud inválida"), @ApiResponse(code = 201, message = "Cliente creado correctamente")})
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVo) {

		Cliente cliente = new Cliente();
		cliente.setApellido(clienteVo.getApellido());
		cliente.setDireccion(clienteVo.getDireccion());
		cliente.setEmail(clienteVo.getEmail());
		cliente.setIdDocument(clienteVo.getIdDocument());
		cliente.setNombre(clienteVo.getNombre());
		cliente.setTelefono(clienteVo.getTelefono());

		return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{identificacion}")
	@ApiOperation(value = "Actualizar un cliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Cliente no encontrado"), @ApiResponse(code = 201, message = "Cliente actualizado correctamente")})
	public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion") String identificacion,
			ClienteVO clienteVo) {

		Cliente cliente = clienteService.findByIdDocument(identificacion);

		if (cliente != null) {

			cliente.setApellido(clienteVo.getApellido());
			cliente.setDireccion(clienteVo.getDireccion());
			cliente.setEmail(clienteVo.getEmail());
			cliente.setIdDocument(clienteVo.getIdDocument());
			cliente.setNombre(clienteVo.getNombre());
			cliente.setTelefono(clienteVo.getTelefono());

			return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("{identificacion}")
	@ApiOperation(value = "Eliminar un cliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Cliente no encontrado"), @ApiResponse(code = 201, message = "Cliente eliminado correctamente")})
	public void deleteCliente(@PathVariable("identificacion") String identificacion) {
		Cliente cliente = this.clienteService.findByIdDocument(identificacion);
		if (cliente != null) {
			this.clienteService.delete(cliente);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Listar clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Clientes no encontrados"), @ApiResponse(code = 201, message = "Clientes encontrados correctamente")})
	public ResponseEntity<List<Cliente>> findAll(){
		return ResponseEntity.ok(this.clienteService.findAll());
	}
	
}
