package com.laboratorio.laboratorio_reservas.services;


import com.laboratorio.laboratorio_reservas.models.Reserva;
import com.laboratorio.laboratorio_reservas.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> getReservaById(String id) {
        return reservaRepository.findById(id);
    }

    public Reserva saveReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void deleteReserva(String id) {
        reservaRepository.deleteById(id);
    }
}
