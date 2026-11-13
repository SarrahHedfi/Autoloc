package tn.esprit.autoloc.Services;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(* tn.esprit.autoloc.Services..*(..))")
    public Object surveillerExecution(
            ProceedingJoinPoint joinPoint) throws Throwable {

        String methode = joinPoint.getSignature().toShortString();
        long debut = System.currentTimeMillis();

        log.info("Début d'exécution : {}", methode);

        try {
            Object resultat = joinPoint.proceed();
            long duree = System.currentTimeMillis() - debut;

            log.info("Fin d'exécution : {}", methode);
            log.info("Durée : {} ms", duree);

            return resultat;
        } catch (Throwable ex) {
            log.error("Erreur dans {} : {}", methode, ex.getMessage());
            throw ex;
        }
    }

    // Partie D : uniquement les méthodes annotées @OperationSurveillance
    @Around("@annotation(OperationSurveillance)")
    public Object surveillerOperation(
            ProceedingJoinPoint joinPoint) throws Throwable {

        long debut = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        } finally {
            long duree = System.currentTimeMillis() - debut;
            log.info("Opération surveillée : {} - {} ms",
                    joinPoint.getSignature().getName(), duree);
        }
    }
}