package com.doisbitsw.licencas.api.itens;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItensService {

    @Autowired

    private ItensRepository rep;
    public List<ItensDTO> getCarros() {
        List<ItensDTO> list = rep.findAll().stream().map(ItensDTO::create).collect(Collectors.toList());
        return list;
    }

    public ItensDTO getCarroById(Long id) {
        Optional<Itens> carro = rep.findById(id);
        return carro.map(ItensDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }



    public List<ItensDTO> getCarrosByCode(String code) {
        return rep.findByCode(code).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getCarrosByEscola(Long escola) {
        return rep.findByEscola(escola).stream().map(ItensDTO::create).collect(Collectors.toList());
    }

    public long getCart(){
        return rep.findCart();
    }

    public long getUltimoId(){
        return rep.findUltimoId();
    }

    public long getTemCart(Long escola){
        return rep.findTemCart(escola);
    }

    public long getTemCart1(Long escola){
        return rep.findTemCart1(escola);
    }



    public List<ItensDTO> getId(Long id) {
        return rep.findId(id).stream().map(ItensDTO::create).collect(Collectors.toList());
    }




    public ItensDTO insert(Itens itens) {
        Assert.isNull(itens.getId(),"Não foi possível inserir o registro");
        return ItensDTO.create(rep.save(itens));
    }

    public ItensDTO update(Itens itens, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Itens> optional = rep.findById(id);
        if(optional.isPresent()) {
            Itens db = optional.get();
            // Copiar as propriedades
            db.setAtivo(itens.getAtivo());
            db.setCode(itens.getCode());
            db.setIscheck(itens.getIscheck());
            db.setStatus(itens.getStatus());
            db.setIsaf(itens.getIsaf());
            db.setTotal(itens.getTotal());
            db.setIscart(itens.getIscart());
            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ItensDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
