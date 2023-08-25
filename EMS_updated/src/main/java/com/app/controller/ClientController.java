package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddClientDTO;
import com.app.dto.ResponseClientDTO;
import com.app.dto.UpdateClientDTO;
import com.app.entities.Client;
import com.app.service.ClientService;

@CrossOrigin
@RestController
@RequestMapping("/clients")
@Validated
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping
	public ResponseEntity<?> addingClient(@RequestBody @Valid AddClientDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.addClient(dto));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
		
	}
    
	@DeleteMapping("/{clientId}")
	public ResponseEntity<?> deletingClient(@PathVariable Long clientId){
		return ResponseEntity.status(HttpStatus.OK).body(clientService.deleteClient(clientId));
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllClient(){
		return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
	}
	
	@PutMapping("/{clientId}")
	public ResponseEntity<?> updateClient(@PathVariable Long clientId,@RequestBody @Valid UpdateClientDTO dto){
		dto.setId(clientId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientService.update(clientId, dto));
		
	}


	    @PatchMapping("/{clientId}")
	    public ResponseEntity<?> updateClients(@PathVariable Long clientId, @RequestBody UpdateClientDTO  clientDto) {
	        ResponseClientDTO updatedClient = clientService.partialUpdateClient(clientId, clientDto);
	        return ResponseEntity.ok(updatedClient);
	    }

	    
}

 
