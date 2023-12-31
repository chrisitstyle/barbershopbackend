package pl.barbershopproject.restapi.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.barbershopproject.restapi.model.Offer;
import pl.barbershopproject.restapi.repository.OfferRepository;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class OfferService {

    private final OfferRepository offerRepository;

    // Create
    public Offer addOffer(Offer offer){

        return offerRepository.save(offer);
    }
    // Read

    public List<Offer> getOffers(){

        return offerRepository.findAll();
    }
    public Offer getSingleOffer(long id_offer) {
        return offerRepository.findById(id_offer).orElseThrow();
    }
    // Update
    public Offer updateOffer(Offer updatedOffer, Long id_offer){
        return offerRepository.findById(id_offer)
                .map(offer -> {
                    offer.setKind(updatedOffer.getKind());
                    offer.setCost(updatedOffer.getCost());
                    return offerRepository.save(offer);
                }).orElseThrow(NoSuchElementException::new);
    }
    // Delete

    public void deleteOffer(long id_offer) {

        offerRepository.deleteById(id_offer);
        System.out.println("Offer with id " + id_offer + " has been deleted");

    }
}
