package controllers;

import app.BloodDonationApp;
import app.entities.BloodDonation;
import app.entities.BloodDonator;
import app.repositories.BloodDonationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BloodDonationApp.class)
@DataJpaTest
@ActiveProfiles("test")
public class BloodDonationRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private BloodDonationRepository bloodDonationRepository;

    @Test
    public void testFindDonationsByBloodDonatorId() {
        BloodDonator bloodDonatorOne = new BloodDonator();
        bloodDonatorOne.setFirstName("Иван");
        bloodDonatorOne.setLastName("Иванов");
        bloodDonatorOne.setActiveBloodDonator(true);
        Set<BloodDonation> bloodDonations = new HashSet<>();

        Calendar firstCalendar = new GregorianCalendar();
        firstCalendar.set(2018, 9, 6);//months in Java start from 0 witch is equal to January
        Date dateOne = firstCalendar.getTime();

        BloodDonation bloodDonationOne = new BloodDonation();
        bloodDonationOne.setBloodDonationDate(dateOne);
        bloodDonationOne.setBloodDonator(bloodDonatorOne);
        bloodDonations.add(bloodDonationOne);

        Calendar secondCalendar = new GregorianCalendar();
        secondCalendar.set(2018, 10, 6);//months in Java start from 0 witch is equal to January
        Date dateTwo = secondCalendar.getTime();

        BloodDonation bloodDonationTwo = new BloodDonation();
        bloodDonationTwo.setBloodDonationDate(dateTwo);
        bloodDonationTwo.setBloodDonator(bloodDonatorOne);
        bloodDonations.add(bloodDonationTwo);

        Calendar thirdCalendar = new GregorianCalendar();
        thirdCalendar.set(2018, 11, 6);
        Date dateThree = thirdCalendar.getTime();

        BloodDonation bloodDonationThree = new BloodDonation();
        bloodDonationThree.setBloodDonationDate(dateThree);
        bloodDonationThree.setBloodDonator(bloodDonatorOne);
        bloodDonations.add(bloodDonationThree);
        bloodDonatorOne.setBloodDonations(bloodDonations);

        this.testEntityManager.persistAndFlush(bloodDonatorOne);

        BloodDonator bloodDonatorTwo = new BloodDonator();
        bloodDonatorTwo.setFirstName("Христо");
        bloodDonatorTwo.setLastName("Петров");
        bloodDonatorTwo.setActiveBloodDonator(true);
        Set<BloodDonation> bloodDonationsTwo = new HashSet<>();

        Calendar fourthCalendar = new GregorianCalendar();
        fourthCalendar.set(2017, 4, 6);
        Date dateFour = fourthCalendar.getTime();

        BloodDonation bloodDonationFour = new BloodDonation();
        bloodDonationFour.setBloodDonationDate(dateFour);
        bloodDonationFour.setBloodDonator(bloodDonatorTwo);
        bloodDonationsTwo.add(bloodDonationFour);

        Calendar fifthCalendar = new GregorianCalendar();
        fifthCalendar.set(2017, 3, 6);
        Date dateFive = fifthCalendar.getTime();

        BloodDonation bloodDonationFive = new BloodDonation();
        bloodDonationFive.setBloodDonationDate(dateFive);
        bloodDonationFive.setBloodDonator(bloodDonatorTwo);
        bloodDonationsTwo.add(bloodDonationFive);

        Calendar sixthCalendar = new GregorianCalendar();
        sixthCalendar.set(2017, 5, 6);
        Date dateSix = sixthCalendar.getTime();

        BloodDonation bloodDonationSix = new BloodDonation();
        bloodDonationSix.setBloodDonationDate(dateSix);
        bloodDonationSix.setBloodDonator(bloodDonatorTwo);
        bloodDonationsTwo.add(bloodDonationSix);
        bloodDonatorTwo.setBloodDonations(bloodDonationsTwo);

        this.testEntityManager.persistAndFlush(bloodDonatorTwo);

        BloodDonator bloodDonatorThree = new BloodDonator();
        bloodDonatorThree.setFirstName("Димитър");
        bloodDonatorThree.setLastName("Петков");
        bloodDonatorThree.setActiveBloodDonator(true);
        Set<BloodDonation> bloodDonationsThree = new HashSet<>();

        Calendar seventhCalendar = new GregorianCalendar();
        seventhCalendar.set(2018, 10, 8);
        Date dateSeven = seventhCalendar.getTime();

        BloodDonation bloodDonationSeven = new BloodDonation();
        bloodDonationSeven.setBloodDonationDate(dateSeven);
        bloodDonationSeven.setBloodDonator(bloodDonatorThree);
        bloodDonationsThree.add(bloodDonationSeven);

        Calendar eghthCalendar = new GregorianCalendar();
        eghthCalendar.set(2013, 3, 6);
        Date dateEight = eghthCalendar.getTime();

        BloodDonation bloodDonationEight = new BloodDonation();
        bloodDonationEight.setBloodDonationDate(dateEight);
        bloodDonationEight.setBloodDonator(bloodDonatorThree);
        bloodDonationsThree.add(bloodDonationEight);

        Calendar ninthCalendar = new GregorianCalendar();
        ninthCalendar.set(2017, 5, 16);
        Date dateNine = ninthCalendar.getTime();

        BloodDonation bloodDonationNine = new BloodDonation();
        bloodDonationNine.setBloodDonationDate(dateNine);
        bloodDonationNine.setBloodDonator(bloodDonatorThree);
        bloodDonationsThree.add(bloodDonationNine);
        bloodDonatorThree.setBloodDonations(bloodDonationsThree);

        this.testEntityManager.persistAndFlush(bloodDonatorThree);

        this.testEntityManager.persistAndFlush(bloodDonationOne);
        this.testEntityManager.persistAndFlush(bloodDonationTwo);
        this.testEntityManager.persistAndFlush(bloodDonationThree);
        this.testEntityManager.persistAndFlush(bloodDonationFour);
        this.testEntityManager.persistAndFlush(bloodDonationFive);
        this.testEntityManager.persistAndFlush(bloodDonationSix);
        this.testEntityManager.persistAndFlush(bloodDonationSeven);
        this.testEntityManager.persistAndFlush(bloodDonationEight);
        this.testEntityManager.persistAndFlush(bloodDonationNine);


        List<BloodDonation> bloodDonationsList = this.bloodDonationRepository.findDonationsByBloodDonatorId(3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
        StringBuilder result = new StringBuilder();
        int size = bloodDonationsList.size();
        for (int i = 0; i < size; i++) {
            String date = simpleDateFormat.format(bloodDonationsList.get(i).getBloodDonationDate().getTime());
            result.append(date);
            if (i < size - 1) {
                result.append(",");
            }
        }

        assertEquals("06/Април/2013,16/Юни/2017,08/Ноември/2018", result.toString());

        //"06/Октомври/2018,06/Ноември/2018,06/Декември/2018" for id=2
        //"06/Април/2017,06/Май/2017,06/Юни/2017"  for id=2
        //"06/Април/2013,16/Юни/2017,08/Ноември/2018" for id=3

    }
}
