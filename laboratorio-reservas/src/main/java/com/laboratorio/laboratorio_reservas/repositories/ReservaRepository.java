package com.laboratorio.laboratorio_reservas.repositories;


import com.laboratorio.laboratorio_reservas.models.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends MongoRepository<Reserva, String> {}

