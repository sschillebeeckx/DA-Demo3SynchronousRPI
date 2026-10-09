package be.ucll.menuitemservice.business;

import be.ucll.menuitemservice.dto.Restaurant;
import be.ucll.menuitemservice.persistence.MenuItem;
import be.ucll.menuitemservice.persistence.MenuItemRepository;
import be.ucll.menuitemservice.restaurantproxy.RestaurantProxyInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;
    private final RestaurantProxyInterface restaurantProxy;

    public MenuItemService(MenuItemRepository menuItemRepository, RestaurantProxyInterface restaurantProxy) {
        this.menuItemRepository = menuItemRepository;
        this.restaurantProxy = restaurantProxy;
    }

    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    public List<MenuItem> findByRestaurant(Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }

    public MenuItem findById(Long id) {
        return menuItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu item not found: " + id));
    }

    public MenuItem save(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public List<Restaurant> findAllRestaurants(){
        return restaurantProxy.findAll();
    }
}
