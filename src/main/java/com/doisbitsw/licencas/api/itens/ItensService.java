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

    public List<ItensDTO> getCarros2() {
        List<ItensDTO> list = rep.findAll2().stream().map(ItensDTO::create).collect(Collectors.toList());
        return list;
    }

    public List<ItensDTO> getCarros3() {
        List<ItensDTO> list = rep.findAll3().stream().map(ItensDTO::create).collect(Collectors.toList());
        return list;
    }

    public ItensDTO getCarroById(Long id) {
        Optional<Itens> carro = rep.findById(id);
        return carro.map(ItensDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public List<ItensDTO> getCarrosByPedido(String pedido) {
        return rep.findByPedido(pedido).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getCarrosByPedidoAll(String pedido) {
        return rep.findByPedidoAll(pedido).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getCarrosByAf(Long af) {
        return rep.findByAf(af).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getCarrosByEscola(Long escola, Long pedido) {
        return rep.findByEscola(escola,pedido).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getEscolar(Long escola, Long ano) {
        return rep.findEscolar(escola,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getByFornecedor(Long fornecedor) {
        return rep.findByFornecedor(fornecedor).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getEscolaAll(Long ano) {
        return rep.findEscolaAll(ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getItensAno(Long ano) {
        return rep.findItensAno(ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }



    public List<ItensDTO> getTotalMes(Long ano) {
        return rep.findTotalMes(ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getTotalMesNivel(Long nivel,Long ano) {
        return rep.findTotalMesNivel(nivel,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getTotalMesEscola(Long escola,Long ano) {
        return rep.findTotalMesEscola(escola,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getTotalCategoria(Long ano) {
        return rep.findTotalCategoria(ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getTotalCategoriaNivel(Long nivel,Long ano) {
        return rep.findTotalCategoriaNivel(nivel,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getTotalCategoriaEscola(Long escola,Long ano) {
        return rep.findTotalCategoriaEscola(escola,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }

    public List<ItensDTO> getTotalEscolas(Long ano) {
        return rep.findTotalEscolas(ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getTotalEscolaNivel(Long nivel,Long ano) {
        return rep.findTotalEscolaNivel(nivel,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }




    public List<ItensDTO> getMediaAlunos(Long ano) {
        return rep.findMediaAlunos(ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getMediaAlunosNivel(Long nivel,Long ano) {
        return rep.findMediaAlunosNivel(nivel,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public double getTotal(Long ano){
        return rep.findTotal(ano);
    }


    public double getTotalNivel(Long nivel,Long ano){
        return rep.findTotalNivel(nivel,ano);
    }


    public double getTotalEscola(Long escola,Long ano){
        return rep.findTotalEscola(escola,ano);
    }


    public double getSoma(Long escola){
        return rep.findSoma(escola);
    }



    public double getTotalAgroEscola(Long escola,Long ano){
        return rep.findTotalAgroEscola(escola,ano);
    }

    public double getTotalAgroNivel(Long nivel,Long ano){
        return rep.findTotalAgroNivel(nivel,ano);
    }


    public double getTotalAgro(Long ano){
        return rep.findTotalAgro(ano);
    }

    public double getTotalPedido(String pedido){
        return rep.findTotalPedido(pedido);
    }

    public double getTotalAf(Long af){
        return rep.findTotalAf(af);
    }

    public double getTradicional(Long ano){
        return rep.findTradicional(ano);
    }


    public double getTradicionalNivel(Long nivel,Long ano){
        return rep.findTradicionalNivel(nivel,ano);
    }


    public double getTradicionalEscola(Long escola,Long ano){
        return rep.findTradicionalEscola(escola,ano);
    }



    public double getDiversos(Long ano){
        return rep.findDiversos(ano);
    }


    public double getDiversosNivel(Long nivel,Long ano){
        return rep.findDiversosNivel(nivel,ano);
    }


    public double getDiversosEscola(Long escola,Long ano){
        return rep.findDiversosEscola(escola,ano);
    }






    public ItensDTO insert(Itens pedidoItens) {
        Assert.isNull(pedidoItens.getId(),"Não foi possível inserir o registro");
        return ItensDTO.create(rep.save(pedidoItens));
    }

    public ItensDTO update(Itens pedidoItens, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Itens> optional = rep.findById(id);
        if(optional.isPresent()) {
            Itens db = optional.get();
            // Copiar as propriedades
            db.setEscola(pedidoItens.getEscola());
            db.setProduto(pedidoItens.getProduto());
            db.setCategoria(pedidoItens.getCategoria());
            db.setNivel(pedidoItens.getNivel());
            db.setFornecedor(pedidoItens.getFornecedor());
            db.setAno(pedidoItens.getAno());
            db.setAf(pedidoItens.getAf());
            db.setPedido(pedidoItens.getPedido());
            db.setAlias(pedidoItens.getAlias());
            db.setObs(pedidoItens.getObs());
            db.setStatus(pedidoItens.getStatus());
            db.setCreated(pedidoItens.getCreated());
            db.setNomeescola(pedidoItens.getNomeescola());
            db.setNomenivel(pedidoItens.getNomenivel());
            db.setUnidade(pedidoItens.getUnidade());
            db.setQuantidade(pedidoItens.getQuantidade());
            db.setValor(pedidoItens.getValor());
            db.setTotal(pedidoItens.getTotal());
            db.setIsagro(pedidoItens.getIsagro());
            db.setIsautorizado(pedidoItens.getIsautorizado());
            db.setIscheck(pedidoItens.getIscheck());
            db.setCod(pedidoItens.getCod());
            db.setMes(pedidoItens.getMes());
            db.setAtivo(pedidoItens.getAtivo());

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
