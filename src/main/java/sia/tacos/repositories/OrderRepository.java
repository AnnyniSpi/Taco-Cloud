package sia.tacos.repositories;

import org.springframework.data.repository.CrudRepository;
import sia.tacos.model.TacoOrder;


public interface OrderRepository  extends CrudRepository<TacoOrder, Long> {
}
