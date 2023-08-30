package sia.rabbitMq.kitchen;

import jakarta.jms.JMSException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import sia.tacos.model.TacoOrder;

@Component
public class RabbitOrderReceiver implements OrderReceiver {

    private RabbitTemplate rabbit;
    private MessageConverter messageConverter;

    @Autowired
    public RabbitOrderReceiver(RabbitTemplate rabbit, MessageConverter messageConverter) {
        this.rabbit = rabbit;
        this.messageConverter = messageConverter;
    }

//    @Override
//    public TacoOrder receiverOrder() {
//        Message message = rabbit.receive("tacocloud.order");
//        return message != null
//                ? (TacoOrder) messageConverter.fromMessage(message)
//                : null;
//    }

    @Override
    public TacoOrder receiverOrder() {
        return (TacoOrder) rabbit.receiveAndConvert(
                "tacocloud.order",
                new ParameterizedTypeReference<TacoOrder>() {

                });
    }
}
