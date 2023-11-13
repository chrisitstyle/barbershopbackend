package pl.barbershopproject.restapi.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.barbershopproject.restapi.model.Order;
import pl.barbershopproject.restapi.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    //create
    @PostMapping("")
    public String addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return "Zamówienie dodane";
    }
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
    @PutMapping("/{id_order}")
    public Order updateOrder(@RequestBody Order updatedOrder, @PathVariable Long id_order){
        return orderService.updateOrder(updatedOrder,id_order);
    }
    //delete
}
