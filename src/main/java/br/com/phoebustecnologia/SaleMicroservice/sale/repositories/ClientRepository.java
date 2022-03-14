package br.com.phoebustecnologia.SaleMicroservice.sale.repositories;

import br.com.phoebustecnologia.SaleMicroservice.sale.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);
}
