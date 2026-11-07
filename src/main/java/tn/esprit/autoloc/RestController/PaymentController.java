package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.Entities.Paiement;
import tn.esprit.autoloc.Services.IPayment;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/apiPayment")
@RequiredArgsConstructor
@Tag(name=("Gestion Payment"))
public class PaymentController {
    private final IPayment iPayment;
    @GetMapping("/GetByMontant/{montant}")
    public List<Paiement> findByMontantLessThanEqual(
            @PathVariable BigDecimal montant){
        return iPayment.findByMontantLessThanEqual(montant);
    }
}
