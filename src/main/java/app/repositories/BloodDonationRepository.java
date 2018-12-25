package app.repositories;

import app.entities.BloodDonation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodDonationRepository extends CrudRepository<BloodDonation,Long> {


    @Query("SELECT bd FROM BloodDonation AS bd WHERE bd.bloodDonator.id=:id ORDER BY bd.bloodDonationDate ASC ")
    List<BloodDonation> findDonationsByBloodDonatorId(@Param("id") long bloodDonatorId);


}
