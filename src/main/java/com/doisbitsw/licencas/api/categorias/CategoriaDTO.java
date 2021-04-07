package com.doisbitsw.licencas.api.categorias;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CategoriaDTO {
    private Long id;
    private String nome;
    private String image;
    private Boolean isativo;


    public static CategoriaDTO create(Categoria categoria) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(categoria, CategoriaDTO.class);
    }
}
