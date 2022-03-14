package br.com.phoebustecnologia.SaleMicroservice.sale.dto;

import br.com.phoebustecnologia.SaleMicroservice.sale.model.Book;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Client;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Sale;
import br.com.phoebustecnologia.SaleMicroservice.sale.model.Status;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDTO implements Serializable {

    private static final long SerialVersionId =  1L;
    private Long id;

    private Long clientId;

    private Set<Book> bookPurchase;

    private Double valuePurchase;

    private OffsetDateTime datePurchase;

    @Enumerated(EnumType.STRING)
    private Status status;



    public static SaleDTO saleDTO(Sale saleEntity){
        return builder()
                .id(saleEntity.getId())
                .clientId(saleEntity.getClientId())
                .bookPurchase(saleEntity.getBookPurchase())
                .valuePurchase(saleEntity.getValuePurchase())
                .datePurchase(saleEntity.getDatePurchase())
                .status(saleEntity.getStatus())
                .build();
    }

    public static List<SaleDTO> ListFromAllSales (List<Sale> sales) {
        return sales.stream().map(SaleDTO::saleDTO).collect(Collectors.toList());
    }

    public static SaleDTO saleSavedDTO(Sale saleEntity){
        return builder()
                .clientId(saleEntity.getClientId())
                .bookPurchase(saleEntity.getBookPurchase())
                .valuePurchase(saleEntity.getValuePurchase())
                .datePurchase(saleEntity.getDatePurchase())
                .status(saleEntity.getStatus())
                .build();
    }

}
