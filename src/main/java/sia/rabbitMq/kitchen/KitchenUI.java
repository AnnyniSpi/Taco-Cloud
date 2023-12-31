package sia.rabbitMq.kitchen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import sia.tacos.model.TacoOrder;

@Slf4j
@Component
public class KitchenUI {

    public void displayOrder(TacoOrder order){
        log.info("RECEIVED ORDER: " + order);
    }
}
