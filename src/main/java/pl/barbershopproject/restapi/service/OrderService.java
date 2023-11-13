package pl.barbershopproject.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.barbershopproject.restapi.model.Order;
import pl.barbershopproject.restapi.repository.OrderRepository;
import java.util.NoSuchElementException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    // create
    public String addOrder(Order order){

        orderRepository.save(order);
        return "Zamówienie dodane";
    }
    // read
    public List<Order> getOrders(){

        return orderRepository.findAll();
    }

    public Order gestSingleOrder(long id_order){

        return orderRepository.findById(id_order).orElseThrow(NoSuchElementException::new);
    }
    // update
    //delete

}
