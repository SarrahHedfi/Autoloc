package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Paiement;

import java.math.BigDecimal;
import java.util.List;

public interface IPayment {
    List<Paiement> findByMontantLessThanEqual(
            BigDecimal montant);
}
