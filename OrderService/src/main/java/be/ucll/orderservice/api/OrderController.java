package be.ucll.orderservice.api;

import be.ucll.orderservice.business.OrderService;
import be.ucll.orderservice.dto.Customer;
import be.ucll.orderservice.dto.MenuItem;
import be.ucll.orderservice.persistence.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderService.save(order);
    }

    @GetMapping("customers")
    public List<Customer> findAllCustomers(){
        return orderService.findAllCustomers();
    }

    @GetMapping("menu-items")
    public List<MenuItem> findAllMenuItems(){
        return orderService.findAllMenuItems();
    }

    @GetMapping("menu-items/{id}")
    public MenuItem findMenuItem(@PathVariable Long id){
        return orderService.findMenuItem(id);
    }


}