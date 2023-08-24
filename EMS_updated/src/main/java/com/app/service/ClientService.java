package com.app.service;

import java.util.List;

import com.app.dto.AddClientDTO;
import com.app.dto.ApiResponse;
import com.app.dto.ResponseClientDTO;
import com.app.dto.UpdateClientDTO;
import com.app.entities.Client;

public interface ClientService {
   ResponseClientDTO addClient(AddClientDTO client);

   ResponseClientDTO update(Long clientId,UpdateClientDTO client);

   ApiResponse deleteClient(Long clientId);

   List<ResponseClientDTO> findAll();

   ResponseClientDTO findById(Long id);
   
   ResponseClientDTO partialUpdateClient(Long clientId ,UpdateClientDTO clientDto);

}
