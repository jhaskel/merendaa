package com.doisbitsw.licencas.api.fornecedor;

import com.doisbitsw.licencas.api.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    @Query(value = "SELECT *  FROM fornecedor WHERE id = :id ", nativeQuery = true)
    List<Fornecedor> findId(Long id);

}
