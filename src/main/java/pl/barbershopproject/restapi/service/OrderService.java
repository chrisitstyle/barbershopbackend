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
    public Order updateOrder(Order updatedOrder, Long id_order) {
        return orderRepository.findById(id_order)
                .map(order -> {
                    order.setCustomer(updatedOrder.getCustomer());
                    order.setEmployee(updatedOrder.getEmployee());
                    order.setOffer(updatedOrder.getOffer());
                    order.setOrderDate(updatedOrder.getOrderDate());
                    order.setVisitDate(updatedOrder.getVisitDate());
                    return orderRepository.save(order);
                }).orElseThrow(NoSuchElementException::new);
    }
    //delete
    public void deleteOrder(long id_order){
        orderRepository.deleteById(id_order);
        System.out.println("Order with id " + id_order + " has been deleted");

    }

}
