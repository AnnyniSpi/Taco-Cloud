package sia.kafka;


import sia.tacos.model.TacoOrder;

public interface OrderMessagingService {

    void sendOrder(TacoOrder order);
}
