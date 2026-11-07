package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Paiement;
import tn.esprit.autoloc.Repositories.PaymentRepo;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements IPayment{
    private final PaymentRepo paymentRepo;
    @Override
    public List<Paiement> findByMontantLessThanEqual(BigDecimal montant) {
        return paymentRepo.findByMontantLessThanEqual(montant);
    }
}
