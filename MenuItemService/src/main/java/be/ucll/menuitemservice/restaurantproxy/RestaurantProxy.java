package be.ucll.menuitemservice.restaurantproxy;

import be.ucll.menuitemservice.dto.Restaurant;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RestaurantProxy implements RestaurantProxyInterface{

    private final RestTemplate restTemplate;
    private String baseUrl="http://localhost:8082/restaurants";

    public RestaurantProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Restaurant> findAll() {
        Restaurant[] restaurants= restTemplate.getForObject(baseUrl , Restaurant[].class);
        return Arrays.asList(restaurants);
    }

    @Override
    public Restaurant findById(Long id) {
        return restTemplate.getForObject(baseUrl+"/"+id , Restaurant.class);
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return restTemplate.postForObject(baseUrl,restaurant,Restaurant.class);
    }
}
