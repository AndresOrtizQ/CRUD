package com.Softbarv4.Softbarv4.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Softbarv4.Softbarv4.Model.Reserva;

@Repository
public interface ReservaRepo extends CrudRepository<Reserva,Long> {

}
