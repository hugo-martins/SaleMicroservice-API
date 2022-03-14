package br.com.phoebustecnologia.SaleMicroservice.sale.service;

import br.com.phoebustecnologia.SaleMicroservice.sale.dto.PurchaseDTO;
import br.com.phoebustecnologia.SaleMicroservice.sale.dto.SaleDTO;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Status;

import java.util.List;

public interface SaleService {

    //Listar venda pelo Status;
    List<SaleDTO> findByStatus(Status status);

    //Listar Vendas
    List<SaleDTO> findAll();

    //Pesquisar Sale por ID
    SaleDTO findById(Long id);

    //Deletar Sale
    void delete(Long id);

    //Salvar Sale
    SaleDTO save(SaleDTO saleDTO);

    //Atualizar Sale
    SaleDTO update(Long id, SaleDTO saleDTO);
}
