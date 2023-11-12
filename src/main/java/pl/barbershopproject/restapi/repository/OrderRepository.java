package pl.barbershopproject.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.barbershopproject.restapi.model.Order;

public interface OrderRepository extends JpaRepository <Order, Long> {


}
