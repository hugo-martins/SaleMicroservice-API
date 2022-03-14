package br.com.phoebustecnologia.SaleMicroservice.FeignConfig;

import br.com.phoebustecnologia.SaleMicroservice.sale.dto.ClientDTO;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Component
@FeignClient(name ="client-microservice-service")
public interface ClientFeign {

    @GetMapping(path = "/findClient/{email}")
    Optional<Client> findByEmail(@PathVariable String email );

    @GetMapping(value = "clients/{id}")
    Client clientById(@PathVariable Long id);
}
