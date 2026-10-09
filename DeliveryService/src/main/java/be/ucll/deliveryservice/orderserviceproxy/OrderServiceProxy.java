package be.ucll.deliveryservice.orderserviceproxy;

import be.ucll.deliveryservice.dto.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class OrderServiceProxy implements OrderServiceProxyInterface{

    private final RestTemplate restTemplate;

    //This is the new url based on the service discovery!!!
    private String baseUrl="http://order-service/orders";
    //private String baseUrl="http://localhost:8084/orders";

    public OrderServiceProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Order> findAll() {
        Order[] orders = restTemplate.getForObject(baseUrl,Order[].class);
        return Arrays.asList(orders);
    }

    @Override
    public Order findById(Long id) {
        return restTemplate.getForObject(baseUrl+"/"+id, Order.class);
    }
}
