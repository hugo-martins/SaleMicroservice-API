package br.com.phoebustecnologia.SaleMicroservice.sale.dto;

import br.com.phoebustecnologia.SaleMicroservice.sale.model.SexClient;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class ClientDTO implements Serializable {
    private static final long SerialVersionId =  1L;
    private String name;

    private String phone;

    private String email;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private SexClient sex;

    public static ClientDTO clientSaleDTO(ClientDTO entity){
        return builder()
                .name(entity.getName())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .age(entity.getAge())
                .sex(entity.getSex())
                .build();
    }

}
