package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.Entities.StatutReservation;
import tn.esprit.autoloc.Repositories.ReservationRepo;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservation {

    private final ReservationRepo reservationRepository;

    @Override
    @Scheduled(fixedRate = 60000)
    @OperationSurveillance
    @Transactional
    public void terminerReservationsExpirees() {
        List<Reservation> reservations =
                reservationRepository.findByStatutAndDateFinBefore(
                        StatutReservation.CONFIRMEE,
                        LocalDate.now()
                );

        for (Reservation reservation : reservations) {
            reservation.setStatut(StatutReservation.TERMINEE);
        }

        reservationRepository.saveAll(reservations);
    }

    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> recupererReservations() {
        return reservationRepository.findAll();
    }
    @Override
    @OperationSurveillance
    @Transactional
    public Reservation annulerReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable"));
        reservation.setStatut(StatutReservation.ANNULEE);
        return reservationRepository.save(reservation);
    }
}