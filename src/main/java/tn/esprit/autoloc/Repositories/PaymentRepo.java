package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.Entities.Employe;
import tn.esprit.autoloc.Entities.Paiement;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Paiement,Long> {
    List<Paiement> findByMontantLessThanEqual(
            BigDecimal montant);
}
