package com.doisbitsw.licencas.api.carros;

import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.modelmapper.ModelMapper;

@Data
public class CarroDTO {
    private Long id;
    private String nome;
    private String tipo;
    private String descricao;
    private String urlFoto;
    private String urlVideo;
    private String latitude;
    private String longitude;
    @JsonIgnore
    private String novo;

    /*public CarroDTO(Carro carro) {
        this.id = carro.getId();
        this.nome = carro.getNome();
        this.tipo = carro.getTipo();
    }*/

    public static CarroDTO create(Carro carro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(carro, CarroDTO.class);
    }



}
