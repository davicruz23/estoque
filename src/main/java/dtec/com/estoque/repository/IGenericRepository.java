package dtec.com.estoque.repository;

import org.springframework.data.repository.ListCrudRepository;
import dtec.com.estoque.domain.AbstractEntity;
public interface IGenericRepository<E extends AbstractEntity> extends ListCrudRepository<E, Long> {

}
