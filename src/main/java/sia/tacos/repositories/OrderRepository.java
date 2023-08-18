package sia.tacos.repositories;

import sia.tacos.model.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
