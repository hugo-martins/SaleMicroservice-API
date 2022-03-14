package br.com.phoebustecnologia.SaleMicroservice.sale.service;

import br.com.phoebustecnologia.SaleMicroservice.FeignConfig.ClientFeign;
import br.com.phoebustecnologia.SaleMicroservice.sale.dto.BookDTO;
import br.com.phoebustecnologia.SaleMicroservice.sale.dto.ClientDTO;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Book;
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


    public ClientDTO findByClient(Long id) {
        ClientDTO clientDTO = clientFeign.clientById(id);
        try {
            if (clientRepository.existsById(id)) ;
            Client client = clientRepository.save(Client.clientSaved(clientDTO));
            return ClientDTO.clientSaleDTO(client);

        } catch (FeignException e) {
            throw new FeignException.BadRequest("Client Not Found: " + Client.class, null, null, null);
        }
    }

}
