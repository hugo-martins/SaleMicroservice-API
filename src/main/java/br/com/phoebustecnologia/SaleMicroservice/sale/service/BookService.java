package br.com.phoebustecnologia.SaleMicroservice.sale.service;

import br.com.phoebustecnologia.SaleMicroservice.sale.model.Book;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.Optional;

//@FeignClient(name = "book-microservice-service", url = "http://localhost:8080/book-microservice-service/books/")
public interface BookService {

    Optional<Book> findByTitle(String title);

}
