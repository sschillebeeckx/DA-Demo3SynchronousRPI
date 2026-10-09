package be.ucll.deliveryservice.business;

import be.ucll.deliveryservice.dto.Order;
import be.ucll.deliveryservice.orderserviceproxy.OrderServiceProxyInterface;
import be.ucll.deliveryservice.persistence.Delivery;
import be.ucll.deliveryservice.persistence.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final OrderServiceProxyInterface orderServiceProxy;

    public DeliveryService(DeliveryRepository deliveryRepository, OrderServiceProxyInterface orderServiceProxy) {
        this.deliveryRepository = deliveryRepository;
        this.orderServiceProxy = orderServiceProxy;
    }

    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    public Delivery findById(Long id) {
        return deliveryRepository.findById(id).orElseThrow(() -> new RuntimeException("Delivery not found: " + id));
    }

    public Delivery save(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Order findOrderById(Long id){
        return orderServiceProxy.findById(id);
    }
}
