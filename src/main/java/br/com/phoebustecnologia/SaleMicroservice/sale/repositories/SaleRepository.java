package br.com.phoebustecnologia.SaleMicroservice.sale.repositories;

import br.com.phoebustecnologia.SaleMicroservice.sale.model.Sale;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByStatus(Status status);

}

