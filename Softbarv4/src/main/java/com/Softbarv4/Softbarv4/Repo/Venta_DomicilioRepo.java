package com.Softbarv4.Softbarv4.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Softbarv4.Softbarv4.Model.Venta_Domicilio;

@Repository
public interface Venta_DomicilioRepo extends CrudRepository<Venta_Domicilio,Long> {

}
