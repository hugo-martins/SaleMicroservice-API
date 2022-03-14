package br.com.phoebustecnologia.SaleMicroservice.sale.service;

import br.com.phoebustecnologia.SaleMicroservice.FeignConfig.ClientFeign;
import br.com.phoebustecnologia.SaleMicroservice.sale.dto.ClientDTO;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Client;
import br.com.phoebustecnologia.SaleMicroservice.sale.repositories.ClientRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientFeign clientFeign;

    public Optional<Client> findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }


    public Client findByClient(Long id) {
        Client client = clientFeign.clientById(id);
        try {
            if (clientRepository.existsById(id));
                return clientRepository.save(client);

        } catch (FeignException e) {
            throw new FeignException.BadRequest("Client Not Found: " + Client.class, null, null, null);
        }
    }

}
