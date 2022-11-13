package com.cep.br.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_ADDRESS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "CD_IBGE")
    private String cdIbge;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "LOCALIDADE")
    private String localidade;

    @Column(name = "ESTADO")
    private String estado;

}
