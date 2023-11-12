package pl.barbershopproject.restapi.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.barbershopproject.restapi.model.Employee;
import pl.barbershopproject.restapi.model.Offer;
import pl.barbershopproject.restapi.service.OfferService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    // Create
    @PostMapping("")
    public Offer addOffer(@RequestBody Offer offer){
        return offerService.addOffer(offer);
    }
    // Read

    @GetMapping("")
    public List<Offer> getOffers(){

        return offerService.getOffers();

    }
    @GetMapping("/{id_offer}")
    public Offer getSingleOffer(@PathVariable long id_offer){
        return offerService.getSingleOffer(id_offer);
    }
    // Update
    @PutMapping("/{id_offer}")
    public Offer updateOffer(@RequestBody Offer updatedOffer, @PathVariable Long id_offer){
        return offerService.updateOffer(updatedOffer,id_offer);
    }
    // Delete
    @DeleteMapping("/{id_offer}")
    public void deleteOffer(@PathVariable long id_offer){

       offerService.deleteOffer(id_offer);
    }





}
