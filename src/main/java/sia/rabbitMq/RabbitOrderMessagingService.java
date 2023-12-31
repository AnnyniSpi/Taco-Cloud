package sia.rabbitMq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;
import sia.tacos.model.TacoOrder;

@Service
public class RabbitOrderMessagingService implements OrderMessagingService{

    private RabbitTemplate rabbit;

    public RabbitOrderMessagingService(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

//    @Override
//    public void sendOrder(TacoOrder order) {
//        MessageConverter converter =rabbit.getMessageConverter();
//        MessageProperties props = new MessageProperties();
//        props.setHeader("X_ORDER_SOURCE", "WEB");
//        Message message = converter.toMessage(order, props);
//
//        rabbit.send("kitchens.students", message);
//    }

    @Override
    public void sendOrder(TacoOrder order) {
        rabbit.convertAndSend(order, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                MessageProperties props = message.getMessageProperties();
                props.setHeader("X_ORDER_SOURCE", "WEB");
                return message;
            }
        });
    }
}
