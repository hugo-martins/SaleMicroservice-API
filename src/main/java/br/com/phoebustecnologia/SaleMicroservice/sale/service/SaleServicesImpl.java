package br.com.phoebustecnologia.SaleMicroservice.sale.service;

import br.com.phoebustecnologia.SaleMicroservice.exceptions.SaleNotFoundException;
import br.com.phoebustecnologia.SaleMicroservice.sale.dto.BookDTO;
import br.com.phoebustecnologia.SaleMicroservice.sale.dto.ClientDTO;
import br.com.phoebustecnologia.SaleMicroservice.sale.dto.SaleDTO;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Book;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Client;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Sale;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Status;
import br.com.phoebustecnologia.SaleMicroservice.sale.repositories.BookRepository;
import br.com.phoebustecnologia.SaleMicroservice.sale.repositories.ClientRepository;
import br.com.phoebustecnologia.SaleMicroservice.sale.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SaleServicesImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BookServiceImpl bookService;



    //Pesquisar lista de vendas pelo Status
    @Override
    public List<SaleDTO> findByStatus(Status status){
        return SaleDTO.ListFromAllSales(saleRepository.findByStatus(status));
    }

    //Pesquisar lista de Compras
    @Override
    public List<SaleDTO> findAll(){
        return SaleDTO.ListFromAllSales(saleRepository.findAll());
    }

    //Pesquisar venda por ID;
    @Override
    public SaleDTO findById(Long id){
        Sale result = saleRepository.findById(id)
                .orElseThrow(SaleNotFoundException::new);
        return SaleDTO.saleDTO(result);
    }

    //Salvar venda
    @Override
    @Transactional
    public SaleDTO save(SaleDTO saleDTO){

        Set<Book> bookSet = new HashSet<>();
        for (Book b : saleDTO.getBookPurchase()){
            BookDTO bookDTO = bookService.findBook(b.getId());
            Book book = Book.bookFrom(bookDTO);
            bookSet.add(book);
            bookRepository.save(book);

        }
        Client clientById = clientService.findByClient(saleDTO.getClientId());
        clientRepository.save(clientById);


        Sale saleSaved = Sale.saleConvertDTO(saleDTO);
        saleSaved.setClientId(clientById.getId());
        saleSaved.setBookPurchase(bookSet);

        saleSaved.setDatePurchase(OffsetDateTime.now());
        Sale save = saleRepository.save(saleSaved);

        return SaleDTO.saleSavedDTO(save);


    }

    //Deletar venda
    @Override
    public void delete(Long id){
        Sale sale = saleRepository.findById(id)
                .orElseThrow(SaleNotFoundException::new);

        saleRepository.delete(sale);
    }

    //Atualizar venda
    @Override
    @Transactional
    public SaleDTO update(Long id, SaleDTO saleDTO) {
        Sale sale =  saleRepository.findById(id)
                .orElseThrow(SaleNotFoundException::new);

        Set<Book> bookSet = new HashSet<>();

        for (Book b : sale.getBookPurchase()) {
            Optional<Book> book = bookRepository.findById(b.getId());
            bookSet.addAll(sale.getBookPurchase());
        }
        sale.setBookPurchase(bookSet);


        Sale saleConvert = Sale.saleConvertDTO(saleDTO);
        updateValuesSale(sale, saleConvert);
        Sale saleSaved = saleRepository.save(sale);
        return SaleDTO.saleSavedDTO(saleSaved);
    }

    //Método para salvar e atualizar entidades das vendas
    public void updateValuesSale(Sale newObj, Sale oldObj){
        newObj.setClientId(oldObj.getClientId());
        newObj.setBookPurchase(oldObj.getBookPurchase());
        newObj.setValuePurchase(oldObj.getValuePurchase());
        newObj.setDatePurchase(oldObj.getDatePurchase());
        newObj.setStatus(oldObj.getStatus());

    }

}
