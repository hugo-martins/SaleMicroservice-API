package br.com.phoebustecnologia.SaleMicroservice.sale.model;

import br.com.phoebustecnologia.SaleMicroservice.sale.dto.ClientDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class Client implements Serializable {
    private static final long SerialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String phone;

    private String email;

    private SexClient sex;

    @OneToMany(mappedBy = "clientId")
    private Set<Sale> sale;

    public static Client clientSaved (ClientDTO dto){
        return builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .age(dto.getAge())
                .sex(dto.getSex())
                .build();
    }




}
