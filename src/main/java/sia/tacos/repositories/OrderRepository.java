package sia.tacos.repositories;

import org.springframework.data.repository.CrudRepository;
import sia.tacos.model.TacoOrder;

import java.util.UUID;

public interface OrderRepository  extends CrudRepository<TacoOrder, UUID> {
}
