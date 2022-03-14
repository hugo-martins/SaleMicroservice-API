package br.com.phoebustecnologia.SaleMicroservice.sale.dto;

import br.com.phoebustecnologia.SaleMicroservice.sale.model.Book;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class BookDTO implements Serializable {
    private static final long serialVersionId = 1L;

    private Long id;

    private String title;

    private String synopsis;

    private String isbn;

    private String author;

    private String publicationYear;

    private Double priceSell;

    private Integer availableQuantity;


    public static  BookDTO bookDTO(Book bookEntity){
        return BookDTO
                .builder()
                .title(bookEntity.getTitle())
                .isbn(bookEntity.getIsbn())
                .synopsis(bookEntity.getSynopsis())
                .author(bookEntity.getAuthor())
                .publicationYear(bookEntity.getPublicationYear())
                .priceSell(bookEntity.getPriceSell())
                .build();
    }

}
