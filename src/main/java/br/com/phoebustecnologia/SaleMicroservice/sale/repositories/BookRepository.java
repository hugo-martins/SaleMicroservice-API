package br.com.phoebustecnologia.SaleMicroservice.sale.repositories;

import br.com.phoebustecnologia.SaleMicroservice.sale.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);


}
