package be.ucll.deliveryservice.orderserviceproxy;

import be.ucll.deliveryservice.dto.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OrderServiceProxyInterface {
     List<Order> findAll();
     Order findById(Long id);
}
