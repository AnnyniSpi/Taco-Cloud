package sia.tacos.controllers.api;

import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sia.tacos.model.TacoOrder;
import sia.tacos.repositories.OrderRepository;

@RestController
@RequestMapping(path = "/api/orders",
                produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class OrderRestController {

    private final OrderRepository orderRepo;

    public OrderRestController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder putOrder(@PathVariable("orderId") Long orderId,
                              @RequestBody TacoOrder order){
        order.setId(orderId);
        return orderRepo.save(order);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder patchOrder(@PathVariable("orderId") Long orderId,
                                @RequestBody TacoOrder patch) {

        TacoOrder order = orderRepo.findById(orderId).get();

        if (patch.getDeliveryName() != null) {
            order.setDeliveryName(patch.getDeliveryName());
        }
        if (patch.getDeliveryStreet() != null) {
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }
        if (patch.getDeliveryCity() != null) {
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        if (patch.getDeliveryState() != null) {
            order.setDeliveryState(patch.getDeliveryState());
        }
        if (patch.getDeliveryZip() != null) {
            order.setDeliveryZip(patch.getDeliveryZip());
        }
        if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }
        return orderRepo.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId){
        try {
            orderRepo.deleteById(orderId);
        } catch (EmptyResultDataAccessException e){
        }
    }

}
