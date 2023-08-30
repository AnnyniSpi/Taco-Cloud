package sia.rabbitMq.kitchen;

import jakarta.jms.JMSException;
import sia.tacos.model.TacoOrder;

public interface OrderReceiver {
    TacoOrder receiverOrder();
}
