package com.doisbitsw.licencas.api.carros;

import lombok.Data;
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
    private String novo;


    public static CarroDTO create(Carro carro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(carro, CarroDTO.class);
    }



}
