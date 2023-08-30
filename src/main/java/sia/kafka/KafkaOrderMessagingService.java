package sia.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import sia.tacos.model.TacoOrder;

@Service
public class KafkaOrderMessagingService implements OrderMessagingService{

    private final KafkaTemplate<String, TacoOrder> kafka;

    @Autowired
    public KafkaOrderMessagingService(KafkaTemplate<String, TacoOrder> kafka) {
        this.kafka = kafka;
    }

    @Override
    public void sendOrder(TacoOrder order) {
        kafka.sendDefault(order);
    }
}
