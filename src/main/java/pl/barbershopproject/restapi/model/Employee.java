package pl.barbershopproject.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Table(name = "employee")
@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long idEmployee;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "e-mail")
    private String email;
    private String password;

    @OneToMany(mappedBy = "employee")
    @JsonIgnoreProperties("employee")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Order> employeeOrders;

}
