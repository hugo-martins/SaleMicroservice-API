package br.com.phoebustecnologia.SaleMicroservice.sale.model;

import br.com.phoebustecnologia.SaleMicroservice.sale.dto.BookDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book implements Serializable {
    private static final long serialVersionId = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String synopsis;

    private String isbn;

    private String author;

    private String publicationYear;

    private Double priceSell;

    private Integer availableQuantity;

    @JsonIgnore
    @ManyToMany(mappedBy = "bookPurchase", fetch = FetchType.EAGER)
    private Set<Sale> sale;

    public static Book bookFrom(BookDTO bookDTO) {
        return Book
                .builder()
                .title(bookDTO.getTitle())
                .isbn(bookDTO.getIsbn())
                .synopsis(bookDTO.getSynopsis())
                .author(bookDTO.getAuthor())
                .publicationYear(bookDTO.getPublicationYear())
                .priceSell(bookDTO.getPriceSell())
                .availableQuantity(bookDTO.getAvailableQuantity())
                .build();
    }


}
