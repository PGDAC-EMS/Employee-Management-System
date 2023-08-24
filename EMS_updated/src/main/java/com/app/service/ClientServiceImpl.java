package com.app.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import java.util.Optional;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AddClientDTO;
import com.app.dto.ApiResponse;
import com.app.dto.ResponseClientDTO;
import com.app.dto.ResponseEmpDTO;
import com.app.dto.UpdateClientDTO;
import com.app.entities.Client;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.ClientRepo;

@Transactional
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    public ClientRepo clientDao;
    
    @Autowired
    private ModelMapper mapper;
   

    public ClientServiceImpl() {
    }


	@Override
	public List<ResponseClientDTO> findAll() {
		List<Client> clientList=clientDao.findAll();
		//TypeMap<Client, ResponseClientDTO> typeMap = mapper.createTypeMap(Client.class, ResponseClientDTO.class);
		return clientList.stream() 
				.map(client -> mapper.map(client, ResponseClientDTO.class)) 
				.collect(Collectors.toList());
	}

	@Override
	public ResponseClientDTO findById(Long id) {
		Client client= clientDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("invalid client id!!"));
		return mapper.map(client, ResponseClientDTO.class);
	}




	@Override
	public ResponseClientDTO addClient(AddClientDTO client) {
		Client client1=mapper.map(client,Client.class);
		return mapper.map(clientDao.save(client1),ResponseClientDTO.class);
	}




	@Override
	public ResponseClientDTO update(Long clientId,UpdateClientDTO dto) {
		Client client=mapper.map(findById(clientId),Client.class);
		mapper.map(dto, client);// but after this id : null
		client.setId(clientId);
		clientDao.save(client);
		return mapper.map(client,ResponseClientDTO.class);
		
	}

	@Override
	public ApiResponse deleteClient(Long clientId) {
		Client client=mapper.map(findById(clientId), Client.class);
		clientDao.delete(client);
		return new ApiResponse("client deleted Successfully!!");
	}
	
	


	@Override
	public ResponseClientDTO partialUpdateClient(Long clientId ,UpdateClientDTO clientDto) {
		Client existingClient = clientDao.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        if (clientDto.getCName() != null) {
            existingClient.setCName(clientDto.getCName());
        }
        if (clientDto.getCEmail() != null) {
            existingClient.setCEmail(clientDto.getCEmail());
        }
        if (clientDto.getCContact() != null) {
            existingClient.setCContact(clientDto.getCContact());
        }

        return mapper.map(clientDao.save(existingClient),ResponseClientDTO.class);
	}

	  


}
