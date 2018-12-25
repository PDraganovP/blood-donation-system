package app.repositories;

import app.entities.Address;
import app.entities.BloodDonationCenter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BloodDonationCenterRepository extends CrudRepository<BloodDonationCenter, Long> {

    List<BloodDonationCenter> findAll();

    BloodDonationCenter findByAddress(Address address);

    BloodDonationCenter findById(long id);

    BloodDonationCenter findByName(String name);

    @Query("SELECT dc FROM BloodDonationCenter AS dc JOIN User AS u ON dc.user=u.id WHERE u.username=:username")
    BloodDonationCenter findByUsername(@Param("username") String username);

    @Modifying
    @Query("UPDATE BloodDonationCenter AS bdc SET bdc.name=:name , bdc.address=:address  WHERE bdc.id=:id ")
    void editBloodDonationCenterById(@Param("name") String name, @Param("address") Address address, @Param("id") long id);


}
