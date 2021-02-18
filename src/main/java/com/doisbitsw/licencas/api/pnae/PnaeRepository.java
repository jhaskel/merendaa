package com.doisbitsw.licencas.api.pnae;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PnaeRepository extends JpaRepository<Pnae, Long> {


    @Query(value = "SELECT sum(valor) as soma  FROM pnae \n" +
            "WHERE    ano = :ano ", nativeQuery = true)
    double findSoma(Long ano);

}
