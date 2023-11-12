package pl.barbershopproject.restapi.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.barbershopproject.restapi.model.Order;
import pl.barbershopproject.restapi.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    //create
    //read
    @GetMapping("")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }
    @GetMapping("/{id_order}")
    public Order getSingleOrder(@PathVariable long id_order){
        return orderService.gestSingleOrder(id_order);
    }


    //update
    //delete
}
