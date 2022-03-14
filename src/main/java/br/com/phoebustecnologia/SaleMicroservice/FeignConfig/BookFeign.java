package br.com.phoebustecnologia.SaleMicroservice.FeignConfig;

import br.com.phoebustecnologia.SaleMicroservice.sale.dto.BookDTO;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "book-microservice-service", url = "http://localhost:8080/book-microservice-service/books/")
public interface BookFeign {

    @GetMapping(path = "/findBook/{title}")
    Optional<Book> findByTitle(@PathVariable String title);

    @GetMapping(value = "/{id}")
    public BookDTO bookListById(@PathVariable Long id);

}
