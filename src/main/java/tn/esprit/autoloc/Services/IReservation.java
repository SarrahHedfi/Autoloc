package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Reservation;

import java.util.List;

public interface IReservation {

    void terminerReservationsExpirees();

    Reservation ajouterReservation(Reservation reservation);

    List<Reservation> recupererReservations();
    Reservation annulerReservation(Long id);

}