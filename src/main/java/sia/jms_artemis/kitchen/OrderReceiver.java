package sia.jms_artemis.kitchen;

import jakarta.jms.JMSException;
import sia.tacos.model.TacoOrder;

public interface OrderReceiver {
    TacoOrder receiverOrder() throws JMSException;
}
