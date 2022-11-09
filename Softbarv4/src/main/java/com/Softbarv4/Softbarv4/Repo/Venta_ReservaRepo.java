package com.Softbarv4.Softbarv4.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Softbarv4.Softbarv4.Model.Venta_Reserva;

@Repository
public interface Venta_ReservaRepo extends CrudRepository<Venta_Reserva, Long> {

}
