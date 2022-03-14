package br.com.phoebustecnologia.SaleMicroservice.sale.controller;

import br.com.phoebustecnologia.SaleMicroservice.sale.dto.PurchaseDTO;
import br.com.phoebustecnologia.SaleMicroservice.sale.dto.SaleDTO;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Status;
import br.com.phoebustecnologia.SaleMicroservice.sale.service.SaleServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleServicesImpl saleServicesImpl;

    @GetMapping(value = "/status/{status}")
    public List<SaleDTO> statusSale(@PathVariable Status status){
        return saleServicesImpl.findByStatus(status);

    }

    @GetMapping(value = "/all")
    public List<SaleDTO> saleList() {
        return saleServicesImpl.findAll();

    }

    @GetMapping(value = "/{id}")
    public SaleDTO saleById(@PathVariable Long id){
        return saleServicesImpl.findById(id);

    }

    @PostMapping
    public void addSale(@RequestBody SaleDTO saleDTO) {
        saleServicesImpl.save(saleDTO);
    }


    @DeleteMapping(value = "/{id}")
    public void  delete(@PathVariable Long id) {
        saleServicesImpl.delete(id);

    }

    @PutMapping(value = "/{id}")
    public void updateSale(@PathVariable Long id, @RequestBody SaleDTO saleDTO) {
        saleServicesImpl.update(id, saleDTO);
    }
}
