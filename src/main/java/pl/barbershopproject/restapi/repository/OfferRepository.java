package pl.barbershopproject.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.barbershopproject.restapi.model.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {

}
