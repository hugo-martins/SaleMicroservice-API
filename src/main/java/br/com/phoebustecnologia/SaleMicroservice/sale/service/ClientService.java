package br.com.phoebustecnologia.SaleMicroservice.sale.service;

import br.com.phoebustecnologia.SaleMicroservice.sale.model.Client;

import java.util.Optional;

public interface ClientService {
    Optional<Client> findByEmail(String email);
}
