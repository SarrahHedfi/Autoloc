package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.DTO.VehicuelDTO;
import tn.esprit.autoloc.Entities.Client;
import tn.esprit.autoloc.Entities.StatutVehicule;
import tn.esprit.autoloc.Entities.Vehicule;

import java.util.List;

@Repository
public interface VehiculeRepo extends JpaRepository<Vehicule,Long> {
    List<Vehicule> findByMarque(String marque);
    List<Vehicule> findByStatut(StatutVehicule statut);
    //List<Vehicule> findByStatutEquals(
    //        StatutVehicule.DISPONIBLE);
    List<Vehicule> findByModeleStartingWith(String modele);
//    @Query("SELECT v FROM Vehicule v  WHERE v.agence.id = :idAgence")
//    List<Vehicule> getVehiculesByAgence(
//            @Param("idAgence") Long idAgence);
    //Recuperer la liste des vehicules par agence en utilisant dto
    @Query("SELECT NEW tn.esprit.autoloc.DTO.VehicuelDTO(" +
            "v.immatriculation, v.marque, v.modele) " +
            "FROM Vehicule v " +
            "WHERE v.agence.id = :idAgence")
    List<VehicuelDTO> getVehiculesByAgence(
            @Param("idAgence") Long idAgence);
}
