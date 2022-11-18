package com.prueba.tecnica.repo;

import org.springframework.data.repository.CrudRepository;
import com.prueba.tecnica.model.Cliente;

public interface ClienteRepo extends CrudRepository<Cliente,Long>   {

}
