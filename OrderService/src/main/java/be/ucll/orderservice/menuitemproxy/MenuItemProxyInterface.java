package be.ucll.orderservice.menuitemproxy;

import be.ucll.orderservice.dto.MenuItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MenuItemProxyInterface {

    public List<MenuItem> findAll() ;
    public MenuItem findById(@PathVariable Long id) ;

}
