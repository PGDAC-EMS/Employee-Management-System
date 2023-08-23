package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Client;

public interface ClientRepo extends JpaRepository<Client,Long> {

	Optional<Client> findById(Long clientId);

	//Optional<Client> findByClient(Client client);

}
