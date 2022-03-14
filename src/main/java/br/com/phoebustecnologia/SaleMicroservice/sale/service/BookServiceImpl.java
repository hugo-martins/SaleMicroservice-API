package br.com.phoebustecnologia.SaleMicroservice.sale.service;

import br.com.phoebustecnologia.SaleMicroservice.FeignConfig.BookFeign;
import br.com.phoebustecnologia.SaleMicroservice.sale.dto.BookDTO;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Book;
import br.com.phoebustecnologia.SaleMicroservice.sale.repositories.BookRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookFeign bookFeign;

    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }


    public BookDTO findBook(Long id) {
        BookDTO bookDTO = bookFeign.bookListById(id);
        try {
            if (bookRepository.existsById(id));
            Book book = bookRepository.save(Book.bookFrom(bookDTO));
            return BookDTO.bookDTO(book);
        }
        catch (FeignException e) {
            throw new FeignException.BadRequest("Book Not Found: " + Book.class, null, null, null);
        }
    }
}
