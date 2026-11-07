package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Entities.Vehicule;

import java.util.List;


@Repository
public interface AgenceRepo extends JpaRepository<Agence,Long> {



}
