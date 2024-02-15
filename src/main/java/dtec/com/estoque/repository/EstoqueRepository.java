package dtec.com.estoque.repository;

import dtec.com.estoque.domain.Estoque;

import java.util.Optional;

public interface EstoqueRepository extends IGenericRepository<Estoque>{

    Optional<Estoque> findById(Long id);
}
