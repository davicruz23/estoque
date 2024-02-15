package dtec.com.estoque.repository;

import dtec.com.estoque.domain.Funcionarios;

import java.util.Optional;

public interface FuncionariosRepository extends IGenericRepository<Funcionarios>{

    @Override
    Optional<Funcionarios> findById(Long id);
}
