package sia.jms_artemis;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;
import sia.tacos.model.TacoOrder;

@Service
public class JmsOrderMessagingService implements OrderMessagingService{

    private JmsTemplate jms;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public void sendOrder(TacoOrder order) {
        jms.convertAndSend(
                order,
                this::addOrderSource);
    }

    private Message addOrderSource(Message message) throws JMSException {
            message.setStringProperty("X_ORDER_SOURCE", "WEB");
            return message;
    }

//    @Override
//    public void sendOrder(TacoOrder order) {
//        jms.send(session -> {
//                    Message msg = session.createObjectMessage(order);
//                    msg.setStringProperty("X_ORDER_SOURCE","WEB");
//                    return msg;
//                }
//        );
//    }

}
