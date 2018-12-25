package app.repositories;

import app.entities.Address;
import app.entities.BloodDonator;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BloodDonatorRepository extends CrudRepository<BloodDonator, Long> {

    @Query("SELECT b FROM BloodDonator AS b  WHERE b.firstName LIKE :firstName% ")
    List<BloodDonator> findByFirstName(@Param("firstName") String name);

    @Query("SELECT b FROM BloodDonator AS b JOIN Address a ON b.address=a.id WHERE a.city LIKE :city% ")
    List<BloodDonator> findByCityStartWith(@Param("city") String city);

    BloodDonator findById(long id);

    @Query("SELECT b FROM BloodDonator as b JOIN User u  ON b.user=u.id WHERE u.username=:username")
    BloodDonator findByUsername(@Param("username") String username);

    @Modifying
    @Query("UPDATE BloodDonator AS bd SET bd.firstName=:firstName , bd.age=:age , bd.activeBloodDonator=:isActiveBloodDonator , bd.lastName=:lastName , bd.address=:address  WHERE bd.id=:id ") /*, bd.lastName=:lastName , bd.age=:age , bd.isActiveBloodDonator=:isActiveBloodDonator ,*/
    void editBloodDonatorById(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("age") int age, @Param("isActiveBloodDonator") boolean isActiveBloodDonator, @Param("address") Address address, @Param("id") long id);

}
