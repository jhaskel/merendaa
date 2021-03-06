package com.doisbitsw.escolar.api.pedidos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Long escola;
    private Long nivel;
    private Double total;
    private Long comprador;
    private String status;
    private Long semana;
    private String af;
    private String created;
    private String modified;
    private Boolean ativo;





}

