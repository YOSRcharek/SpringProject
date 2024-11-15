package tn.esprit.charekyosr4twin5.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.charekyosr4twin5.entities.Subscription;
import tn.esprit.charekyosr4twin5.Services.SubscriptionServiceImpl;
import tn.esprit.charekyosr4twin5.entities.TypeSubscription;

import java.util.List;
import java.util.Set;

@Tag(name = "Gestion Subscriptions")
@RestController
@RequiredArgsConstructor
@RequestMapping("/subscription")
public class SubscriptionRestController {

    private final SubscriptionServiceImpl subscriptionService;

    @Operation(description = "ajouter une Subscription de la base de données")
    @PostMapping("/add")
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.addSubscription(subscription);
    }
    @Operation(description = "modifier une Subscription de la base de données")
    @PutMapping("/update")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(subscription);
    }
    @Operation(description = "récupérer une Subscription par num de la base de données")
    @GetMapping("/get/{numSubscription}")
    public Subscription getSubscription(@PathVariable Long numSubscription) {
        return subscriptionService.retrieveSubscription(numSubscription);
    }
    @Operation(description = "récupérer toutes les Subscriptions de la base de données")
    @GetMapping("/all")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }
    @Operation(description = "supprimer une Subscription par num de la base de données")
    @DeleteMapping("/delete/{numSubscription}")
    public void deleteSubscription(@PathVariable Long numSubscription) {
        subscriptionService.removeSubscription(numSubscription);
    }
    @Operation(description = "get Subscriptionby type de la base de données")
    @GetMapping("/byType")
    public Set<Subscription> getSubscriptionsByType(@RequestParam TypeSubscription type) {
        return subscriptionService.getSubscriptionByType(type);
    }

}
