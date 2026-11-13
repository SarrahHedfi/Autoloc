package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.Services.IReservation;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservation reservationService;

    @PostMapping("/ajouter")
    public Map<String, Object> ajouter(@RequestBody Reservation reservation) {
        return resume(reservationService.ajouterReservation(reservation));
    }

    @GetMapping("/all")
    public List<Map<String, Object>> recuperer() {
        return reservationService.recupererReservations()
                .stream().map(this::resume).toList();
    }

    // Évite de sérialiser les relations LAZY (client, véhicule, contrat)
    private Map<String, Object> resume(Reservation r) {
        return Map.of(
                "id", r.getId(),
                "dateDebut", String.valueOf(r.getDateDebut()),
                "dateFin", String.valueOf(r.getDateFin()),
                "statut", String.valueOf(r.getStatut())
        );
    }
    @PutMapping("/annuler/{id}")
    public Map<String, Object> annuler(@PathVariable Long id) {
        return resume(reservationService.annulerReservation(id));
    }
}