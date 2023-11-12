package pl.barbershopproject.restapi.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


@Getter
@Setter
@Table(name = "customer_order")
@Entity
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long idOrder;

    @ManyToOne
    @JoinColumn(name ="id_customer")
    @JsonIgnoreProperties({"customerOrders","idCustomer", "email", "password"}) // ignoruje relację w drugą stronę
    private Customer customer;


   @ManyToOne
   @JoinColumn(name = "id_employee")
   @JsonIgnoreProperties({/*"idEmployee",*/ "email","password"})
   private Employee employee;

    @ManyToOne
    @JoinColumn(name ="id_offer")
   // @JsonIgnoreProperties("idOffer")
    private Offer offer;

    @Column (name = "order_date")
    private LocalDateTime orderDate;

    @Column (name = "visit_date")
    private LocalDateTime visitDate;


}
