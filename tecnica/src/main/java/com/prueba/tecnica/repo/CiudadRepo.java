package com.prueba.tecnica.repo;

import org.springframework.data.repository.CrudRepository;
import com.prueba.tecnica.model.Ciudad;

public interface CiudadRepo extends CrudRepository<Ciudad, Long> {

}
