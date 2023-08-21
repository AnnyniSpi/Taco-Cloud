package sia.tacos.repositories;

import org.springframework.data.repository.CrudRepository;
import sia.tacos.model.TacoOrder;

import java.util.Date;
import java.util.List;

public interface OrderRepository  extends CrudRepository<TacoOrder, Long> {
}
