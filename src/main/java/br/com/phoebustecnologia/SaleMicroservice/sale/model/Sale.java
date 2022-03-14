package br.com.phoebustecnologia.SaleMicroservice.sale.model;

import br.com.phoebustecnologia.SaleMicroservice.sale.dto.SaleDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class Sale implements Serializable {
    private static final long serialVersionId = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_Id")
    private Long clientId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Books_Sales",joinColumns = @JoinColumn(name = "Sale_Id"),inverseJoinColumns =@JoinColumn(name ="Book_id"))
    private Set<Book> bookPurchase;

    @Column(name = "valuePurchase")
    private Double valuePurchase;

    @Column(name = "datePurchase")
    private OffsetDateTime datePurchase;

    @Column (name = "status")
    @Enumerated (EnumType.STRING)
    private Status status;

    public static Sale saleFROM (SaleDTO saleDTO){
        return builder()
                .id(saleDTO.getId())
                .bookPurchase(saleDTO.getBookPurchase())
                .valuePurchase(saleDTO.getValuePurchase())
                .datePurchase(saleDTO.getDatePurchase())
                .status(saleDTO.getStatus())
                .build();
    }

    public static Sale saleConvertDTO(SaleDTO saleEntity){
        return Sale.builder()
                .id(saleEntity.getId())
                .bookPurchase(saleEntity.getBookPurchase())
                .valuePurchase(saleEntity.getValuePurchase())
                .datePurchase(saleEntity.getDatePurchase())
                .status(saleEntity.getStatus())
                .build();
    }
}
