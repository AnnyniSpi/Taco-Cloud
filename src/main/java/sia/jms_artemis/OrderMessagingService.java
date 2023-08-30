package sia.jms_artemis;


import sia.tacos.model.TacoOrder;

public interface OrderMessagingService {

    void sendOrder(TacoOrder order);
}
