package com.doisbitsw.licencas.api.produtos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    @Query(value = "SELECT * FROM produto WHERE ativo = true order by id  ", nativeQuery = true)
    List<Produto> findAll();


    @Query(value = "SELECT * FROM produto p INNER JOIN categoria cat ON cat.id = p.categoria \n" +
            "WHERE p.ativo = TRUE AND cat.isativo = true and p.id NOT IN (SELECT produto FROM itens ite \n" +
            "INNER JOIN pedido ped ON ped.code = ite.pedido WHERE ite.escola = :escola AND ped.iscart = TRUE) ORDER BY p.categoria,p.alias,p.agrofamiliar;  ", nativeQuery = true)
    List<Produto> findByEcola(Long escola);


    @Query(value = "SELECT * FROM produto p\n" +
            "WHERE p.ativo = true and p.id NOT IN (SELECT produto FROM itens ) ORDER BY p.categoria,p.nome", nativeQuery = true)
    List<Produto> findMenos();

    @Query(value = "select * from produto  where ativo = TRUE order by id desc ", nativeQuery = true)
    List<Produto> findByCode(String code);
}
