package com.agnyfonseca.project01crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agnyfonseca.project01crud.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
