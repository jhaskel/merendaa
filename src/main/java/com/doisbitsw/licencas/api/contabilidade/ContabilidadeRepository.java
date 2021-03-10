package com.doisbitsw.licencas.api.contabilidade;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContabilidadeRepository extends JpaRepository<Contabilidade, Long> {
    @Query(value = "SELECT * FROM contabilidade ", nativeQuery = true)
    List<Contabilidade> findAll();

    @Query(value = "SELECT * FROM contabilidade WHERE cod = :cod ", nativeQuery = true)
    List<Contabilidade> findCod(Long cod);

    @Query(value = "SELECT * FROM contabilidade WHERE nivel = :nivel ", nativeQuery = true)
    List<Contabilidade> findNivel(Long nivel);



}
