package pl.barbershopproject.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "customer")
@Entity
public class Customer {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long idCustomer;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "e-mail")
    private String email;
    private String password;

   @OneToMany(mappedBy = "customer")
   //@JsonIgnore // ignoruje pole podczas serializacji
  // @JsonIgnoreProperties({"id_customer","customer"})
   @JsonIgnoreProperties({"customer"})
   @JsonInclude(JsonInclude.Include.NON_EMPTY) // ignoruje pole "customerOrders" gdy jest puste
    private List<Order> customerOrders;
   
}
