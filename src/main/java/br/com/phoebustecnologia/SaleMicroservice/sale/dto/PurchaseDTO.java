package br.com.phoebustecnologia.SaleMicroservice.sale.dto;

import br.com.phoebustecnologia.SaleMicroservice.sale.model.Book;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Client;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Sale;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Status;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseDTO {
    private static final long SerialVersionId =  1L;
    private Long id;

    private String client;

    private Set<Book> bookPurchase;

    private Double valuePurchase;

    private LocalDate datePurchase;

    @Enumerated(EnumType.STRING)
    private Status status;



}
