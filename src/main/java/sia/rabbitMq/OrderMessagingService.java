package sia.rabbitMq;


import sia.tacos.model.TacoOrder;

public interface OrderMessagingService {

    void sendOrder(TacoOrder order);
}
