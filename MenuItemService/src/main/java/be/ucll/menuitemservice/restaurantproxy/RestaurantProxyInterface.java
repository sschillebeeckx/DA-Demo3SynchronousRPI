package be.ucll.menuitemservice.restaurantproxy;

import be.ucll.menuitemservice.dto.Restaurant;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public interface RestaurantProxyInterface {



    public List<Restaurant> findAll() ;

    public Restaurant findById(@PathVariable Long id);

    public Restaurant create(@RequestBody Restaurant restaurant) ;
}

