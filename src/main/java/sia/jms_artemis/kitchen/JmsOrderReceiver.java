package sia.jms_artemis.kitchen;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import sia.tacos.model.TacoOrder;

@Component
public class JmsOrderReceiver implements OrderReceiver {

    private JmsTemplate jms;
    private MessageConverter messageConverter;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jms, MessageConverter messageConverter) {
        this.jms = jms;
        this.messageConverter = messageConverter;
    }

    @Override
    public TacoOrder receiverOrder() throws JMSException {
        Message message = jms.receive("tacocloud.order.queue");
        return (TacoOrder) messageConverter.fromMessage(message);
    }
}
