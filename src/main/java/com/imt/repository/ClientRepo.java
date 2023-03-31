package com.imt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imt.model.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long>{

}
